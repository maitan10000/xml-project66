/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.business.admin;

import fastfood.common.addtionbean.CategoryView;
import fastfood.common.addtionbean.CategoryViews;
import fastfood.common.bean.CategoryBean;
import fastfood.common.dao.CategoryDaoImp;
import fastfood.common.dao.CategoryDaoInterface;
import fastfood.common.utility.XMLTools;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes.Name;

/**
 *
 * @author Everything
 */
public class CategoryBUSImp implements CategoryBUSInterface {

    private CategoryDaoInterface cateDao;

    public CategoryBUSImp() {
        cateDao = new CategoryDaoImp();
    }

    @Override
    public List<CategoryBean> listAll(boolean showActiveOnly) {
        List<CategoryBean> result = new ArrayList<CategoryBean>();
        List<Integer> listCateID = cateDao.ListAllCatID(showActiveOnly);
        for (int i = 0; i < listCateID.size(); i++) {
            result.add(cateDao.ListByCatID(listCateID.get(i)));
        }
        return result;
    }

    public boolean add(String Name) {
        return cateDao.Add(Name);

    }

    public boolean edit(CategoryBean category) {
        return cateDao.Update(category);
    }

    public CategoryBean GetCategorybyID(int ID) {
        return cateDao.ListByCatID(ID);
    }

    public boolean setActive(int ID, boolean active) {
        CategoryBean category = cateDao.ListByCatID(ID);
        category.setIsActive(active);
        return cateDao.Update(category);
    }

    public void exportCategory(String filePath) {
        List<CategoryBean> listCategoryBean = this.listAll(true);
        List<CategoryView> listCategoryView = new ArrayList<CategoryView>();
        for (int i = 0; i < listCategoryBean.size(); i++) {
            CategoryView CategoryView = new CategoryView();
            CategoryBean CategoryBean = listCategoryBean.get(i);
            CategoryView.setID(CategoryBean.getID());
            CategoryView.setName(CategoryBean.getName());
            listCategoryView.add(CategoryView);
        }
        CategoryViews categoryViews = new CategoryViews();
        categoryViews.setCategoryView(listCategoryView);
        XMLTools.JAXBMarshalling(categoryViews, filePath);
    }
}
