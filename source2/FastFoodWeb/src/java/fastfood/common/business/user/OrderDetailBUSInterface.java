/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.business.user;

import fastfood.common.bean.OrderDetailBean;
import java.util.List;

/**
 *
 * @author Everything
 */
public interface OrderDetailBUSInterface {

    public List<OrderDetailBean> listOrderDetailByOrderID(int orderID);
}
