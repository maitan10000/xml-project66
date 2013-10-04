/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FastFood.Common.Business.Admin;

import FastFood.Common.Bean.ProductBean;

/**
 *
 * @author Everything
 */
public interface ProductBUSInterface {

    public boolean add(ProductBean product);
    public boolean update(ProductBean product);
    public boolean setActive(int productID, boolean active);
}
