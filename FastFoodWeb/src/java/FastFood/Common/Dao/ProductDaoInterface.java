/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FastFood.Common.Dao;
import FastFood.Common.Bean.ProductBean;
import java.util.List;
/**
 *
 * @author bao
 */
public interface ProductDaoInterface {
    public boolean Add(ProductBean product);
    public boolean Update(ProductBean product);
    public boolean Delete(int ID);
    public ProductBean ListByProductID(int ID);
    public List<Integer> ListAllProductID();
    public List<Integer> ListByCatID();
}
