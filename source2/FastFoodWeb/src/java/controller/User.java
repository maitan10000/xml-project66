/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import fastfood.common.addtionbean.AccountResult;
import fastfood.common.bean.UserBean;
import fastfood.common.business.admin.UserBUSImp;
import fastfood.common.business.admin.UserBUSInterface;
import fastfood.common.business.user.AccountBUSImp;
import fastfood.common.business.user.AccountBUSInterface;
import fastfood.common.constants.FastFoodContants;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Everything
 */
public class User extends HttpServlet {

    final static String UserLogin = "User/Login.jsp";
    final static String UserResetPass = "User/Reset.jsp";
    //profile
    final static String UserEditProfile = "User/Profile/Edit.jsp";
    final static String UserViewProfile = "User/Profile/View.jsp";
    final static String HomePage = "/";
    final static String invalid = "invalid.jsp";
    static String url = invalid;
    static String action = "";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        action = request.getParameter(FastFoodContants.ACTION);
        HttpSession session = request.getSession();
        session.removeAttribute(FastFoodContants.SESSION_MSG);
        if (action.equals(FastFoodContants.LOGIN)) {
            url = UserLogin;
        } else if (action.equals(FastFoodContants.RESET_PASS)) {
            url = UserResetPass;
        } else if (action.equals(FastFoodContants.VIEW_PROFILE)) {
            url = UserViewProfile;
        } else if (action.equals(FastFoodContants.EDIT_PROFILE)) {
            url = UserEditProfile;
        }

        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        action = request.getParameter(FastFoodContants.ACTION);
        if (action.equals(FastFoodContants.LOGIN)) {
            String userName = request.getParameter(FastFoodContants.USER_NAME);
            String password = request.getParameter(FastFoodContants.PASSWORD);
            AccountBUSInterface accountBUS = new AccountBUSImp();
            AccountResult result = accountBUS.login(userName, password);
            HttpSession session = request.getSession();
            if (result.isResult() == true) {
                UserBUSInterface userBUS = new UserBUSImp();
                UserBean userBean = userBUS.getUserByUserName(userName);
                session.setAttribute(FastFoodContants.SESSION_LOGIN, userBean);
                url = HomePage;
            } else {
                session.setAttribute(FastFoodContants.SESSION_MSG, result.getMessage());
                url = UserLogin;
            }
        } else if (action.equals(FastFoodContants.RESET_PASS)) {
            String userName = request.getParameter(FastFoodContants.USER_NAME);
            AccountBUSInterface accountBUS = new AccountBUSImp();
            AccountResult result = accountBUS.resetPassword(userName);
            HttpSession session = request.getSession();
            session.setAttribute(FastFoodContants.SESSION_MSG, result.getMessage());
            url = UserResetPass;
        } else if (action.equals(FastFoodContants.EDIT_PROFILE)) {
            String username = request.getParameter(FastFoodContants.USER_NAME);
            String password = request.getParameter(FastFoodContants.PASSWORD);
            String firstname = request.getParameter(FastFoodContants.FIRST_NAME);
            String lastname = request.getParameter(FastFoodContants.LAST_NAME);
            String email = request.getParameter(FastFoodContants.EMAIL);
            String address = request.getParameter(FastFoodContants.ADDRESS);
            String phone = request.getParameter(FastFoodContants.PHONE);

            UserBUSInterface userBUS = new UserBUSImp();
            UserBean user = userBUS.getUserByUserName(username);
            user.setPassword(password);
            user.setFirstName(firstname);
            user.setLastName(lastname);
            user.setEmail(email);
            user.setAddress(address);
            user.setPhone(phone);

            if (userBUS.update(user)) {
                HttpSession session = request.getSession();
                session.setAttribute(FastFoodContants.SESSION_LOGIN, user);
                url = UserViewProfile;
            }
        }

        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";

    }// </editor-fold>
}
