/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FastFood.Common.Business.Admin;

import FastFood.Common.Bean.OrderBean;

/**
 *
 * @author Everything
 */
public interface OrderBUSInterface {    
    public boolean update(OrderBean order);
    public boolean setActive(int orderID, boolean active);
    public boolean updateStatus(int orderID, String status);
}
