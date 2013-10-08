/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.business.user;

import fastfood.common.addtionbean.AccountResult;
import fastfood.common.bean.UserBean;
import fastfood.common.dao.UserDaoImp;
import fastfood.common.dao.UserDaoInterface;
import fastfood.common.utility.Mail;

/**
 *
 * @author Everything
 */
public class AccountBUSImp implements AccountBUSInterface {

    public AccountResult login(String userName, String password) {
        AccountResult result = new AccountResult();
        UserDaoInterface userDao = new UserDaoImp();
        UserBean userBean = userDao.ListByUserName(userName);
        if (userBean != null && userBean.getPassword().equals(password)) {
            result.setResult(true);
            result.setMessage("Login successfull");
        } else {
            result.setResult(false);
            result.setMessage("Login fail");
        }
        return result;
    }

    public AccountResult resetPassword(String userName) {
        AccountResult result = new AccountResult();
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
            result.setResult(true);
            result.setMessage("Please check your email to get password");
        } else {
            result.setResult(false);
            result.setMessage("User not exist");
        }
        return result;
    }
}
