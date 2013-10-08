/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import fastfood.common.addtionbean.AccountResult;
import fastfood.common.bean.UserBean;
import fastfood.common.business.admin.UserBUSImp;
import fastfood.common.business.admin.UserBUSInterface;
import fastfood.common.business.guest.GuestBUSImp;
import fastfood.common.business.guest.GuestBUSInterface;
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
public class Guest extends HttpServlet {

    //Register
    final static String GuestRegister = "Guest/Register.jsp";
    final static String GuestVerify = "Guest/Verify.jsp";
    final static String GuestLogin = "Guest/Login.jsp";
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
        if (action.equals(FastFoodContants.REGISTER)) {
            url = GuestRegister;
        } else if (action.equals(FastFoodContants.VERIFY)) {
            String token = request.getParameter(FastFoodContants.TOKEN);
            GuestBUSInterface guestBUS = new GuestBUSImp();
            AccountResult result = guestBUS.verify(token);
            HttpSession session = request.getSession();
            session.setAttribute(FastFoodContants.SESSION_MSG, result.getMessage());
            url = GuestVerify;
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
        if (action.equals(FastFoodContants.REGISTER)) {
            String username = request.getParameter(FastFoodContants.USER_NAME);
            String password = request.getParameter(FastFoodContants.PASSWORD);
            String firstname = request.getParameter(FastFoodContants.FIRST_NAME);
            String lastname = request.getParameter(FastFoodContants.LAST_NAME);
            String email = request.getParameter(FastFoodContants.EMAIL);
            String address = request.getParameter(FastFoodContants.ADDRESS);
            String phone = request.getParameter(FastFoodContants.PHONE);

            GuestBUSInterface guestBUS = new GuestBUSImp();
            UserBean user = new UserBean();
            user.setUserName(username);
            user.setPassword(password);
            user.setFirstName(firstname);
            user.setLastName(lastname);
            user.setEmail(email);
            user.setAddress(address);
            user.setPhone(phone);
            String serverPath = request.getRequestURL().toString();
            serverPath = serverPath.split("Guest")[0];
            AccountResult result = guestBUS.register(user, serverPath);
            HttpSession session = request.getSession();
            session.setAttribute(FastFoodContants.SESSION_MSG, result.getMessage());
            if (result.isResult() == false) {
                session.setAttribute(FastFoodContants.SESSION_USER, user);
            } else {
            }
            url = GuestRegister;
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
