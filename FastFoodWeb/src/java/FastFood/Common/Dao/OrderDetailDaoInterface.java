/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FastFood.Common.Dao;
import FastFood.Common.Bean.OrderDetailBean;
import java.util.List;
/**
 *
 * @author bao
 */
public interface OrderDetailDaoInterface {
public boolean Add(OrderDetailBean orderDetail);
    public boolean Update(OrderDetailBean orderDetail);
    public boolean Delete(OrderDetailBean orderDetailID);
    public OrderDetailBean ListByOrderDetailID(OrderDetailBean orderDetailID);
    public List<String> ListAllOrderDetailID();
}
