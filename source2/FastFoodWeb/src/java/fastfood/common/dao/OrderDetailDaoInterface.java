/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.dao;

import fastfood.common.bean.OrderDetailBean;
import java.util.List;

/**
 *
 * @author bao
 */
public interface OrderDetailDaoInterface {

    public boolean Add(OrderDetailBean orderDetail);

    public boolean Update(OrderDetailBean orderDetail);

    public boolean Delete(int orderID, int productID);

    public OrderDetailBean ListByOrderDetailID(int orderID, int productID);

    public List<OrderDetailBean> ListByOrderDetailByOrderID(int orderID);

    public List<Integer[]> ListAllOrderDetailID();
}
