/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fastfood.common.dao;

import fastfood.common.bean.UserBean;
import java.util.List;

/**
 *
 * @author Everything
 */
public interface UserDaoInterface {
    public boolean Add(UserBean user);
    public boolean Update(UserBean user);
    public boolean Delete(String UserName);
    public UserBean ListByUserName(String UserName);
    public List<String> ListAllUserName(boolean showActiveOnly);
}
