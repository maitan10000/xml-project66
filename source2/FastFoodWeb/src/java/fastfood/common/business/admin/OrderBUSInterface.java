/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fastfood.common.business.admin;

import fastfood.common.bean.OrderBean;
import java.util.List;

/**
 *
 * @author Everything
 */
public interface OrderBUSInterface {    
    public boolean update(OrderBean order);
    public boolean setActive(int orderID, boolean active);
    public boolean updateStatus(int orderID, String status);

    public List<OrderBean> listAll(boolean showActiveOnly);
}
