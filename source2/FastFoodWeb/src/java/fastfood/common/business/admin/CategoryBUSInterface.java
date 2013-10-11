/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.business.admin;

import fastfood.common.bean.CategoryBean;
import java.util.List;

/**
 *
 * @author Everything
 */
public interface CategoryBUSInterface {

    public List<CategoryBean> listAll(boolean showActiveOnly);

    public boolean add(String Name);

    public boolean edit(CategoryBean category);

    public CategoryBean GetCategorybyID(int ID);

    public boolean setActive(int ID, boolean active);

    public void exportCategory(String filePath);
}
