/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.business.admin;

import fastfood.common.bean.CategoryBean;
import fastfood.common.dao.CategoryDaoImp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Everything
 */
public class CategoryBUSImp implements CategoryBUSInterface {

    private CategoryDaoImp cateDao;

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
}
