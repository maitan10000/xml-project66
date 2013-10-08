/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.business.user;

import fastfood.common.addtionbean.AccountResult;

/**
 *
 * @author Everything
 */
public interface AccountBUSInterface {

    public AccountResult login(String userName, String password);

    public AccountResult resetPassword(String userName);
}
