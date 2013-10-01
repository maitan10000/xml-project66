/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FastFood.Common.Dao;
import FastFood.Common.Bean.CategoryBean;
import java.util.List;

/**
 *
 * @author bao
 */
public interface CategoryDaoInterface {

    public boolean Add(String Name);
    public boolean Update(CategoryBean cate);
    public boolean Delete(int ID);
    public CategoryBean ListByCatID(int ID);
    public List<Integer> ListAllCatID();
}
