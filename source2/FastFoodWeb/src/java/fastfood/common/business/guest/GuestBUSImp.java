/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.business.guest;

import fastfood.common.addtionbean.AccountResult;
import fastfood.common.bean.UserBean;
import fastfood.common.business.admin.UserBUSImp;
import fastfood.common.business.admin.UserBUSInterface;
import fastfood.common.constants.FastFoodContants;
import fastfood.common.dao.UserDaoImp;
import fastfood.common.dao.UserDaoInterface;
import fastfood.common.utility.Mail;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Everything
 */
public class GuestBUSImp implements GuestBUSInterface {

    public AccountResult register(UserBean newUser, String serverPath) {
        AccountResult result = new AccountResult();
        UserDaoInterface userDao = new UserDaoImp();
        if (userDao.ListByUserName(newUser.getUserName()) != null)//user existed
        {
            result.setResult(false);
            result.setMessage("User existed");
        } else {
            newUser.setActive(false);
            if (userDao.Add(newUser)) {
                String userName = newUser.getUserName();
                String to = newUser.getEmail();
                //get token from userName
                BASE64Encoder encoder = new BASE64Encoder();
                String token = encoder.encode(userName.getBytes());
                //send mail
                String linkVerify = serverPath + "Guest?Action=" + FastFoodContants.VERIFY
                        + "&" + FastFoodContants.TOKEN + "=" + token;
                String from = "Verify <accountverify@fastfood.com>";
                String subject = "Verify account";
                String message = "Please verify your account as this link <a href='"
                        + linkVerify + "'>" + linkVerify + "</a>";
                Mail.Send(from, to, subject, message);
                result.setResult(true);
                result.setMessage("Create successfull. Please check your email to verify!");
            } else {
                result.setResult(false);
                result.setMessage("An error occured");
            }
        }
        return result;
    }

    public AccountResult verify(String verifyToken) {
        AccountResult result = new AccountResult();
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            String userName = new String(decoder.decodeBuffer(verifyToken));
            UserBUSInterface userBUS = new UserBUSImp();
            UserBean user = userBUS.getUserByUserName(userName);
            if (user != null) {
                user.setActive(true);
                userBUS.update(user);
                result.setResult(true);
                result.setMessage("Account verify successfull");
            } else {
                result.setResult(true);
                result.setMessage("Acount verify fail");
            }
        } catch (IOException ex) {
            Logger.getLogger(GuestBUSImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
