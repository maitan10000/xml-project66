/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import fastfood.common.addtionbean.ResultBean;
import fastfood.common.bean.OrderBean;
import fastfood.common.bean.UserBean;
import fastfood.common.business.admin.OrderBUSImp;
import fastfood.common.business.admin.OrderBUSInterface;
import fastfood.common.business.admin.UserBUSImp;
import fastfood.common.business.admin.UserBUSInterface;
import fastfood.common.business.user.AccountBUSImp;
import fastfood.common.business.user.AccountBUSInterface;
import fastfood.common.business.user.ShoppingBUSImp;
import fastfood.common.business.user.ShoppingBUSInterface;
import fastfood.common.constants.FastFoodContants;
import fastfood.common.utility.XMLTools;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
    //orderdetail
    final static String UserOrderDetail = "User/OrderDetail.jsp";
    final static String UserOrderList = "User/ListOrder.jsp";
    //admin page
    final static String AdminPage = "Admin/index.jsp";
    final static String HomePage = "Home.jsp";
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
        PrintWriter out = null;
        if (!action.equals(FastFoodContants.PRINT_PDF)) {
            out = response.getWriter();
        }
        try {
            if (action.equals(FastFoodContants.PRINT_PDF))//print pdf
            {
                String orderID = request.getParameter(FastFoodContants.ID);
                String serverPath = getServletContext().getRealPath("/");
                String foPath = serverPath + "Data/out.fo";
                String xmlPath = serverPath + "OrderXML/" + orderID + ".xml";
                String xslPath = serverPath + "Style/orderPDF.xsl";

                byte[] result = XMLTools.PrintPDF(xmlPath, xslPath, foPath);
                if (result != null) {
                    response.setContentType("application/pdf");
                    response.setContentLength(result.length);
                    response.getOutputStream().write(result);
                    response.getOutputStream().flush();
                }
            } else if (action.equals(FastFoodContants.LIST_OLD_ORDER))//list old order
            {
                HttpSession session = request.getSession();
                UserBean userBean = (UserBean) session.getAttribute(FastFoodContants.SESSION_LOGIN);
                OrderBUSInterface orderBUS = new OrderBUSImp();
                List<OrderBean> listOrder = orderBUS.listByBuyer(userBean.getUserName());
                session.setAttribute(FastFoodContants.SESSION_ORDER, listOrder);
                url = UserOrderList;
            } else if (action.equals(FastFoodContants.VIEW_ORDER_DETAIL)) {
                int orderID = Integer.parseInt(request.getParameter(FastFoodContants.ID));

                //create if not exist
                String serverPath = getServletContext().getRealPath("/");
                String schemaFile = serverPath + "Schema/Order.xsd";
                ShoppingBUSInterface shoppingBUS = new ShoppingBUSImp();
                String filePath = serverPath + "OrderXML/" + orderID + ".xml";
                shoppingBUS.exportOrderToXML(orderID, filePath, false);

                HttpSession session = request.getSession();
                session.setAttribute(FastFoodContants.SESSION_ORDER, orderID);
                url = UserOrderDetail + "?ID=" + orderID;
            } else if (action.equals(FastFoodContants.LOGOUT))//logout
            {
                HttpSession session = request.getSession();
                session.removeAttribute(FastFoodContants.SESSION_LOGIN);
                url = HomePage;
            }

            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        } finally {
            if (out != null) {
                out.close();
            }
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
            ResultBean result = accountBUS.login(userName, password);
            HttpSession session = request.getSession();


            if (result.isSuccess() == true) {
                UserBUSInterface userBUS = new UserBUSImp();
                UserBean userBean = userBUS.getUserByUserName(userName);
                session.setAttribute(FastFoodContants.SESSION_LOGIN, userBean);
                if (userBean.getRole().equals("Admin")) {
                    url = AdminPage;
                } else {
                    url = HomePage;
                }
            } else {
                session.setAttribute(FastFoodContants.SESSION_MSG, result.getMessage());
                url = UserLogin;
            }
        } else if (action.equals(FastFoodContants.RESET_PASS)) {
            String userName = request.getParameter(FastFoodContants.USER_NAME);
            AccountBUSInterface accountBUS = new AccountBUSImp();
            ResultBean result = accountBUS.resetPassword(userName);
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
        } else if (action.equals(FastFoodContants.CONFIRM_ORDER)) {
            HttpSession session = request.getSession();
            UserBean currentUser = (UserBean) session.getAttribute(FastFoodContants.SESSION_LOGIN);
            String orderXMl = request.getParameter("Order");
            String receiveAdd = request.getParameter("ReceiveAdd");

            String serverPath = getServletContext().getRealPath("/");
            String schemaFile = serverPath + "Schema/Order.xsd";
            ShoppingBUSInterface shoppingBUS = new ShoppingBUSImp();



            int orderID = shoppingBUS.checkOut(schemaFile, orderXMl, currentUser.getUserName(), receiveAdd);


            if (orderID > -1) {
                String filePath = serverPath + "OrderXML/" + orderID + ".xml";
                shoppingBUS.exportOrderToXML(orderID, filePath, false);
                session.setAttribute(FastFoodContants.SESSION_ORDER, orderID);
                url = UserOrderDetail + "?ID=" + orderID;


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
