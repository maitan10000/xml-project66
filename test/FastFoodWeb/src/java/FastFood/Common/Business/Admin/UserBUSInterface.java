/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FastFood.Common.Business.Admin;

import FastFood.Common.Bean.UserBean;

/**
 *
 * @author Everything
 */
public interface UserBUSInterface {
    public boolean update(UserBean user);
    public boolean setActive(String userName, boolean active);
}
