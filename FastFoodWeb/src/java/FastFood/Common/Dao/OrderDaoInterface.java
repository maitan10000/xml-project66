/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FastFood.Common.Dao;
import FastFood.Common.Bean.OrderBean;
import java.util.List;
/**
 *
 * @author bao
 */
public interface OrderDaoInterface {
    public boolean Add(OrderBean order);

    public boolean Update(OrderBean order);

    public boolean Delete(String ID);

    public OrderBean ListByOrderID(String ID);

    public List<String> ListAllOrderID();
}
