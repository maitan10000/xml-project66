/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FastFood.Common.Dao;

import FastFoodWeb.Common.Bean.UserBean;
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
    public List<String> ListAllUserName();
}
