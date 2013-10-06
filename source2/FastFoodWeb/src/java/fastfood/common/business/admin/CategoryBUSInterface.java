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
}
