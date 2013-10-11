/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.business.guest;

import fastfood.common.addtionbean.ResultBean;
import fastfood.common.bean.UserBean;

/**
 *
 * @author Everything
 */
public interface GuestBUSInterface {

    /**
     * Register new user
     * @param newUser
     * @return 
     */
    public ResultBean register(UserBean newUser, String serverPath);

    /**
     * Verify registered account
     * @param verifyToken
     * @return result
     */
    public ResultBean verify(String verifyToken);
}
