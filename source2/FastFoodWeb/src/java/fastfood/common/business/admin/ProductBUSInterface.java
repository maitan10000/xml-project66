/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.business.admin;

import fastfood.common.bean.ProductBean;
import java.util.List;

/**
 *
 * @author Everything
 */
public interface ProductBUSInterface {

    public boolean add(ProductBean product);

    public boolean update(ProductBean product);

    public boolean setActive(int productID, boolean active);

    public List<ProductBean> listAll(boolean showActiveOnly);

    public ProductBean getProductByID(int ID);

    public void exportProduct(String filePath);
}
