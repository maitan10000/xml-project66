/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.business.admin;

import fastfood.common.bean.UserBean;
import java.util.List;

/**
 *
 * @author Everything
 */
public interface UserBUSInterface {

    public boolean update(UserBean user);

    public boolean setActive(String userName, boolean active);

    public List<UserBean> listAll(boolean showActiveOnly);

    public UserBean getUserByUserName(String userName);
}
