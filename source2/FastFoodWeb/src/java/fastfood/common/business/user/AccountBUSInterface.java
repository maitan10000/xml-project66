/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.business.user;

import fastfood.common.addtionbean.ResultBean;

/**
 *
 * @author Everything
 */
public interface AccountBUSInterface {

    public ResultBean login(String userName, String password);

    public ResultBean resetPassword(String userName);
}
