/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.business.admin;

import fastfood.common.bean.UserBean;
import fastfood.common.dao.UserDaoImp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bao
 */
public class UserBUSImp implements UserBUSInterface {

    private UserDaoImp userDao;

    public UserBUSImp() {
        userDao = new UserDaoImp();
    }

    @Override
    public boolean update(UserBean user) {
        return userDao.Update(user);
    }

    @Override
    public boolean setActive(String userName, boolean active) {
        UserBean user = userDao.ListByUserName(userName);
        user.setActive(active);
        return userDao.Update(user);
    }

    /**
     * Get All User
     * @param showActiveOnly
     * @return list user
     */
    public List<UserBean> listAll(boolean showActiveOnly) {
        List<UserBean> result = new ArrayList<UserBean>();
        List<String> allUserName = userDao.ListAllUserName(showActiveOnly);
        for (int i = 0; i < allUserName.size(); i++) {
            result.add(userDao.ListByUserName(allUserName.get(i)));
        }
        return result;
    }

    public UserBean getUserByUserName(String userName) {
        return userDao.ListByUserName(userName);
    }
}
