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
    public boolean Delete(int orderID, int productID);
    public OrderDetailBean ListByOrderDetailID(int orderID, int productID);
    public List<Integer> ListAllOrderID();
}
