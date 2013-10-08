/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.business.admin;

import fastfood.common.bean.OrderBean;
import fastfood.common.dao.OrderDaoImp;
import fastfood.common.dao.OrderDaoInterface;
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
        List<Integer> allOrderID = orderDao.ListAllOrderID();
        for (int i = 0; i < allOrderID.size(); i++) {
            result.add(orderDao.ListByOrderID(allOrderID.get(i)));
        }
        return result;
    }
}
