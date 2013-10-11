/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.business.user;

import fastfood.common.addtionbean.OrderDetailView;
import fastfood.common.addtionbean.OrderDetailViews;
import fastfood.common.addtionbean.OrderView;
import fastfood.common.addtionbean.ResultBean;
import fastfood.common.bean.OrderBean;
import fastfood.common.bean.OrderDetailBean;
import fastfood.common.bean.ProductBean;
import fastfood.common.bean.UserBean;
import fastfood.common.business.admin.OrderBUSImp;
import fastfood.common.business.admin.OrderBUSInterface;
import fastfood.common.business.admin.ProductBUSImp;
import fastfood.common.business.admin.ProductBUSInterface;
import fastfood.common.business.admin.UserBUSImp;
import fastfood.common.business.admin.UserBUSInterface;
import fastfood.common.constants.FastFoodContants;
import fastfood.common.dao.OrderDaoImp;
import fastfood.common.dao.OrderDaoInterface;
import fastfood.common.dao.OrderDetailDaoImp;
import fastfood.common.dao.OrderDetailDaoInterface;
import fastfood.common.utility.XMLTools;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author Everything
 */
public class ShoppingBUSImp implements ShoppingBUSInterface {

    public int checkOut(String schemaValid, String orderXml, String buyerName, String receiveAdd) {
        OrderBean orderBean = null;
        int OrderID = -1;
        ResultBean result = XMLTools.ValidationFrameworkDOMSource(schemaValid, orderXml);
        if (result.isSuccess() == true) {

            //parse
            try {
                OrderDetailDaoInterface orderDetailDao = new OrderDetailDaoImp();
                OrderDetailBean orderDetailBean = new OrderDetailBean();

                //Create Order
                orderBean = new OrderBean();
                orderBean.setStatus(FastFoodContants.STATUS_UNAPPROVED);
                orderBean.setBuyerName(buyerName);
                orderBean.setReceiveAddress(receiveAdd);
                orderBean.setNotes("");

                OrderDaoInterface orderDao = new OrderDaoImp();
                if (orderDao.Add(orderBean)) {
                    List<Integer> listOrderID = orderDao.ListAllOrderByBuyer(buyerName);
                    OrderID = listOrderID.get(listOrderID.size() - 1);
                }

                if (OrderID > -1) {
                    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                    DocumentBuilder db = dbf.newDocumentBuilder();
                    dbf.setNamespaceAware(true);
                    InputSource is = new InputSource(new StringReader(orderXml));
                    Document doc = db.parse(is);

                    //add each order detail to db
                    NodeList listOrderDetails = doc.getChildNodes().item(0).getChildNodes();
                    for (int i = 0; i < listOrderDetails.getLength(); i++) {
                        NodeList orderDetails = listOrderDetails.item(i).getChildNodes();
                        int productID = Integer.parseInt(orderDetails.item(0).getTextContent());
                        int quantity = Integer.parseInt(orderDetails.item(1).getTextContent());
                        ProductBUSInterface productBUS = new ProductBUSImp();
                        ProductBean productBean = productBUS.getProductByID(productID);
                        if (productBean != null) {
                            int productPrice = productBean.getPrice();
                            //add order detail
                            orderDetailBean.setOrderID(OrderID);
                            orderDetailBean.setProductID(productID);
                            orderDetailBean.setPrice(productPrice);
                            orderDetailBean.setQuantity(quantity);
                            orderDetailDao.Add(orderDetailBean);
                        }
                    }
                }//end if orderID > -1
            } catch (SAXException ex) {
                Logger.getLogger(ShoppingBUSImp.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ShoppingBUSImp.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(ShoppingBUSImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Validation Error: " + result.getMessage());
        }
        return OrderID;
    }

    public void exportOrderToXML(int orderID, String filePath, boolean overWrite) {
        File fileXML = new File(filePath);
        if ((overWrite == true) || (!fileXML.exists())) {
            //create new xml order view
            int total = 0;
            OrderView orderView = new OrderView();
            //get orderBean
            OrderBUSInterface orderBUS = new OrderBUSImp();
            OrderBean orderBean = orderBUS.getOrderByID(orderID);

            //get buyer
            UserBUSInterface userBUS = new UserBUSImp();
            UserBean currentUser = userBUS.getUserByUserName(orderBean.getBuyerName());

            //set orderview
            orderView.setUserName(currentUser.getUserName());
            orderView.setFirstName(currentUser.getFirstName());
            orderView.setLastName(currentUser.getLastName());
            orderView.setEmail(currentUser.getAddress());
            orderView.setPhone(currentUser.getPhone());
            orderView.setReceiveAddress(orderBean.getReceiveAddress());
            orderView.setCreateDate(orderBean.getCreateDate());

            //get orderDetails
            OrderDetailBUSInterface orderDetailBUS = new OrderDetailBUSImp();
            List<OrderDetailBean> listOrderDetail = orderDetailBUS.listOrderDetailByOrderID(orderBean.getID());
            List<OrderDetailView> listOrderDetailView = new ArrayList<OrderDetailView>();
            ProductBUSInterface productBUS = new ProductBUSImp();
            for (int i = 0; i < listOrderDetail.size(); i++) {
                OrderDetailView orderDTView = new OrderDetailView();
                String productName = productBUS.getProductByID(listOrderDetail.get(i).getProductID()).getName();
                orderDTView.setProductName(productName);
                orderDTView.setPrice(listOrderDetail.get(i).getPrice());
                orderDTView.setQuantity(listOrderDetail.get(i).getQuantity());
                int totalTmp = listOrderDetail.get(i).getPrice() * listOrderDetail.get(i).getQuantity();
                total += totalTmp;
                orderDTView.setTotal(totalTmp);
                listOrderDetailView.add(orderDTView);
            }
            OrderDetailViews orderDetailViews = new OrderDetailViews();
            orderDetailViews.setListOrderDetail(listOrderDetailView);
            orderView.setOrderDetailViews(orderDetailViews);
            orderView.setTotalAll(total);

            //marshalling to xml
            XMLTools.JAXBMarshalling(orderView, filePath);
        }
    }
}
