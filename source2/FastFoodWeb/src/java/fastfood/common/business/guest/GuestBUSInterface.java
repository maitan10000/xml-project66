/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.business.guest;

import fastfood.common.addtionbean.AccountResult;
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
    public AccountResult register(UserBean newUser, String serverPath);

    /**
     * Verify registered account
     * @param verifyToken
     * @return result
     */
    public AccountResult verify(String verifyToken);
}
