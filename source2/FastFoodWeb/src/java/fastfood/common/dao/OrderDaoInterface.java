/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fastfood.common.dao;
import fastfood.common.bean.OrderBean;
import java.util.List;
/**
 *
 * @author bao
 */
public interface OrderDaoInterface {
    public boolean Add(OrderBean order);
    public boolean Update(OrderBean order);
    public boolean Delete(int ID);
    public OrderBean ListByOrderID(int ID);
    public List<Integer> ListAllOrderID();
    public List<Integer> ListAllOrderByBuyer(String BuyerName);
    public List<Integer> ListAllOrderByCreator(String Creator);
}
