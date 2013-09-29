/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FastFood.Common.Dao;
import FastFoodWeb.Common.Bean.ProductBean;
import java.util.List;
/**
 *
 * @author bao
 */
public interface ProductDaoInterface {
    public boolean Add(ProductBean product);
    public boolean Update(ProductBean product);
    public boolean Delete(String ID);
    public ProductBean ListByProductID(String ID);
    public List<String> ListAllProductID();
}
