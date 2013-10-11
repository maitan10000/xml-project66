/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.business.user;

import fastfood.common.addtionbean.ResultBean;
import fastfood.common.bean.UserBean;
import fastfood.common.dao.UserDaoImp;
import fastfood.common.dao.UserDaoInterface;
import fastfood.common.utility.Mail;

/**
 *
 * @author Everything
 */
public class AccountBUSImp implements AccountBUSInterface {

    public ResultBean login(String userName, String password) {
        ResultBean result = new ResultBean();
        UserDaoInterface userDao = new UserDaoImp();
        UserBean userBean = userDao.ListByUserName(userName);
        if (userBean != null && userBean.getPassword().equals(password)) {
            result.setSuccess(true);
            result.setMessage("Login successfull");
        } else {
            result.setSuccess(false);
            result.setMessage("Login fail");
        }
        return result;
    }

    public ResultBean resetPassword(String userName) {
        ResultBean result = new ResultBean();
        UserDaoInterface userDao = new UserDaoImp();
        UserBean userBean = userDao.ListByUserName(userName);
        if (userBean != null) {
            String password = userBean.getPassword();
            //Send mail
            String to = userBean.getEmail();
            String from = "Reset Password <resetpassword@fastfood.com>";
            String subject = "Reset Password";
            String message = "Your password: " + password;
            Mail.Send(from, to, subject, message);
            result.setSuccess(true);
            result.setMessage("Please check your email to get password");
        } else {
            result.setSuccess(false);
            result.setMessage("User not exist");
        }
        return result;
    }
}
