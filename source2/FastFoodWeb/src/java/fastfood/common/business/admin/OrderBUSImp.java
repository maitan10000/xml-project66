/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.business.admin;

import fastfood.common.addtionbean.OrderStaticBean;
import fastfood.common.bean.OrderBean;
import fastfood.common.dao.OrderDaoImp;
import fastfood.common.dao.OrderDaoInterface;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Everything
 */
public class OrderBUSImp implements OrderBUSInterface {

    private OrderDaoInterface orderDao;

    public OrderBUSImp() {
        orderDao = new OrderDaoImp();
    }

    @Override
    public boolean update(OrderBean order) {
        return orderDao.Update(order);
    }

    @Override
    public boolean setActive(int orderID, boolean active) {
        OrderBean order = orderDao.ListByOrderID(orderID);
        order.setIsActive(active);
        return orderDao.Update(order);
    }

    @Override
    public boolean updateStatus(int orderID, String status) {
        OrderBean order = orderDao.ListByOrderID(orderID);
        order.setStatus(status);
        return orderDao.Update(order);
    }

    /**
     * List all order
     * @param showActiveOnly
     * @return list order
     */
    public List<OrderBean> listAll(boolean showActiveOnly) {
        List<OrderBean> result = new ArrayList<OrderBean>();
        List<Integer> allOrderID = orderDao.ListAllOrderID(showActiveOnly);
        for (int i = 0; i < allOrderID.size(); i++) {
            result.add(orderDao.ListByOrderID(allOrderID.get(i)));
        }
        return result;
    }

    public OrderBean getOrderByID(int orderID) {
        return orderDao.ListByOrderID(orderID);
    }

    public List<OrderBean> listByBuyer(String buyerName) {
        List<OrderBean> result = new ArrayList<OrderBean>();
        List<Integer> listID = orderDao.ListAllOrderByBuyer(buyerName);
        for (int i = listID.size() - 1; i >= 0; i--) {
            OrderBean orderBean = orderDao.ListByOrderID(listID.get(i));
            if (orderBean.isIsActive() == true) {
                result.add(orderBean);
            }
        }
        return result;
    }

    public List<Integer> listIDByStatus(String status) {
        return orderDao.ListAllOrderByStatus(status);
    }

    public List<OrderStaticBean> listOrderStatic(Date from, Date to) {
        return orderDao.ListOrderStatic(from, to);
    }
}
