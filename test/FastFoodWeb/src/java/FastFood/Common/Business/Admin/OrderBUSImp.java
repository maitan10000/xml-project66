/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FastFood.Common.Business.Admin;

import FastFood.Common.Bean.OrderBean;
import FastFood.Common.Dao.OrderDaoImp;

/**
 *
 * @author Everything
 */
public class OrderBUSImp implements OrderBUSInterface {

    private OrderDaoImp orderDao;

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
}
