/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.business.user;

import fastfood.common.bean.OrderDetailBean;
import fastfood.common.dao.OrderDetailDaoImp;
import fastfood.common.dao.OrderDetailDaoInterface;
import java.util.List;

/**
 *
 * @author Everything
 */
public class OrderDetailBUSImp implements OrderDetailBUSInterface {

    public List<OrderDetailBean> listOrderDetailByOrderID(int orderID) {
        OrderDetailDaoInterface orderDetailDao = new OrderDetailDaoImp();
        return orderDetailDao.ListByOrderDetailByOrderID(orderID);
    }
}
