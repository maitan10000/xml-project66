/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.business.user;

import fastfood.common.bean.OrderBean;
import fastfood.common.bean.UserBean;

/**
 *
 * @author Everything
 */
public interface ShoppingBUSInterface {

    /**
     * Check out
     * @param schemaValid
     * @param orderXml
     * @param buyerName
     * @param receiveAdd
     * @return orderID
     */
    public int checkOut(String schemaValid, String orderXml, String buyerName, String receiveAdd);

    public void exportOrderToXML(int orderID, String filePath, boolean overWrite);
}
