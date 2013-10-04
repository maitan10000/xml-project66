/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FastFood.Common.Business.Admin;

import FastFood.Common.Bean.UserBean;
import FastFood.Common.Dao.UserDaoImp;

/**
 *
 * @author bao
 */
public class UserBUSImp implements UserBUSInterface{
   private UserDaoImp UserDao;
   public UserBUSImp(){
    UserDao = new UserDaoImp();
   }

    @Override
    public boolean update(UserBean user) {
        return UserDao.Update(user);
    }

    @Override
    public boolean setActive(String userName, boolean active) {
        UserBean user = UserDao.ListByUserName(userName);
        user.setActive(active);
        return UserDao.Update(user);
    }

}
