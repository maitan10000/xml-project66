/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FastFood.Common.Dao;
import FastFoodWeb.Common.Bean.CategoryBean;
import java.util.List;

/**
 *
 * @author bao
 */
public interface CategoryDaoInterface {
     public boolean Add(String Name);
    public boolean Update(String Name);
    public boolean Delete(String ID);
    public CategoryBean ListByCatID(String ID);
    public List<String> ListAllCatID();
}
