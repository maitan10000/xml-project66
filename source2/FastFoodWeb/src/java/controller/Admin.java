/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import fastfood.common.bean.CategoryBean;
import fastfood.common.bean.OrderBean;
import fastfood.common.bean.ProductBean;
import fastfood.common.bean.UserBean;
import fastfood.common.business.admin.CategoryBUSImp;
import fastfood.common.business.admin.OrderBUSImp;
import fastfood.common.business.admin.ProductBUSImp;
import fastfood.common.business.admin.UserBUSImp;
import fastfood.common.constants.FastFoodContants;
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
public class Admin extends HttpServlet {

    //Product
    final static String AdminProductList = "Admin/Product/List.jsp";
    final static String AdminProductEdit = "Admin/Product/Edit.jsp";
    final static String AdminProductAdd = "Admin/Product/Add.jsp";
    //User
    final static String AdminUserList = "Admin/User/List.jsp";
    final static String AdminUserEdit = "Admin/User/Edit.jsp";
    //Order
    final static String AdminOrderList = "Admin/Order/List.jsp";
    final static String AdminOrderEdit = "Admin/Order/Edit.jsp";
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
            if (action.equals(FastFoodContants.LIST_PRODUCT)) {
                List<ProductBean> allProduct = new ProductBUSImp().listAll(true);
                if (allProduct != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute(FastFoodContants.SESSION_PRODUCT, allProduct);
                    url = AdminProductList;
                }
            } else if (action.equals(FastFoodContants.DELETE_PRODUCT))//delete product
            {
                int id = Integer.parseInt(request.getParameter(FastFoodContants.ID));
                if (id >= 0) {
                    if (new ProductBUSImp().setActive(id, false)) {
                        List<ProductBean> allProduct = new ProductBUSImp().listAll(true);
                        if (allProduct != null) {
                            HttpSession session = request.getSession();
                            session.setAttribute(FastFoodContants.SESSION_PRODUCT, allProduct);
                            url = AdminProductList;
                        }
                    }
                }
            } else if (action.equals(FastFoodContants.LIST_USER)) //list user
            {
                List<UserBean> allUser = new UserBUSImp().listAll(false);
                if (allUser != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute(FastFoodContants.SESSION_USER, allUser);
                    url = AdminUserList;
                }
            } else if (action.equals(FastFoodContants.DELETE_USER))//delete user
            {
                String username = request.getParameter(FastFoodContants.USER_NAME);
                if (!username.isEmpty()) {
                    if (new UserBUSImp().setActive(username, false)) {
                        List<UserBean> allUser = new UserBUSImp().listAll(false);
                        if (allUser != null) {
                            HttpSession session = request.getSession();
                            session.setAttribute(FastFoodContants.SESSION_USER, allUser);
                            url = AdminUserList;
                        }
                    }
                }
            } else if (action.equals(FastFoodContants.LIST_ORDER))//list order
            {
                List<OrderBean> allOrder = new OrderBUSImp().listAll(true);
                if (allOrder != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute(FastFoodContants.SESSION_ORDER, allOrder);
                    url = AdminOrderList;
                }
            }


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
        if (action.equals(FastFoodContants.EDIT_PRODUCT))//edit product
        {
            int id = Integer.parseInt(request.getParameter(FastFoodContants.ID));
            if (id >= 0) {
                ProductBean productBean = new ProductBUSImp().getProductByID(id);
                List<CategoryBean> listCate = new CategoryBUSImp().listAll(true);
                if (productBean != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute(FastFoodContants.SESSION_PRODUCT, productBean);
                    session.setAttribute(FastFoodContants.SESSION_CATE, listCate);
                    url = AdminProductEdit;
                }
            }
        } else if (action.equals(FastFoodContants.ADD_PRODUCT))//add product
        {
            List<CategoryBean> listCate = new CategoryBUSImp().listAll(true);
            HttpSession session = request.getSession();
            session.setAttribute(FastFoodContants.SESSION_CATE, listCate);
            url = AdminProductAdd;
        } else if (action.equals(FastFoodContants.EDIT_USER))//edit user
        {
            String username = request.getParameter(FastFoodContants.USER_NAME);
            if (!username.isEmpty()) {
                UserBean user = new UserBUSImp().getUserByUserName(username);
                if (user != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute(FastFoodContants.SESSION_USER, user);
                    url = AdminUserEdit;
                }
            }
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


        if (action.equals(FastFoodContants.EDIT_PRODUCT))//edit product
        {
            int id = Integer.parseInt(request.getParameter(FastFoodContants.ID));
            String name = request.getParameter(FastFoodContants.NAME);
            int price = Integer.parseInt(request.getParameter(FastFoodContants.PRICE));
            String image = request.getParameter(FastFoodContants.IMAGE);
            String description = request.getParameter(FastFoodContants.DESCRIPTION);
            int cateID = Integer.parseInt(request.getParameter(FastFoodContants.P_CATEID));
            if (id >= 0) {
                ProductBean productBean = new ProductBUSImp().getProductByID(id);
                productBean.setName(name);
                productBean.setPrice(price);
                productBean.setImage(image);
                productBean.setDescription(description);
                productBean.setCateID(cateID);
                if (new ProductBUSImp().update(productBean)) {
                    List<ProductBean> allProduct = new ProductBUSImp().listAll(true);
                    if (allProduct != null) {
                        HttpSession session = request.getSession();
                        session.setAttribute(FastFoodContants.SESSION_PRODUCT, allProduct);
                        url = AdminProductList;
                    }
                }
            }
        } else if (action.equals(FastFoodContants.ADD_PRODUCT))//add product
        {
            String name = request.getParameter(FastFoodContants.NAME);
            int price = Integer.parseInt(request.getParameter(FastFoodContants.PRICE));
            String image = request.getParameter(FastFoodContants.IMAGE);
            String description = request.getParameter(FastFoodContants.DESCRIPTION);
            int cateID = Integer.parseInt(request.getParameter(FastFoodContants.P_CATEID));
            ProductBean productBean = new ProductBean();
            productBean.setName(name);
            productBean.setPrice(price);
            productBean.setImage(image);
            productBean.setDescription(description);
            productBean.setCateID(cateID);

            if (new ProductBUSImp().add(productBean)) {
                List<ProductBean> allProduct = new ProductBUSImp().listAll(true);
                if (allProduct != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute(FastFoodContants.SESSION_PRODUCT, allProduct);
                    url = AdminProductList;
                }
            }
        } else if (action.equals(FastFoodContants.EDIT_USER))//edit user
        {
            String username = request.getParameter(FastFoodContants.USER_NAME);
            String firstname = request.getParameter(FastFoodContants.FIRST_NAME);
            String lastname = request.getParameter(FastFoodContants.LAST_NAME);
            String email = request.getParameter(FastFoodContants.EMAIL);
            String address = request.getParameter(FastFoodContants.ADDRESS);
            String phone = request.getParameter(FastFoodContants.PHONE);
            String role = request.getParameter(FastFoodContants.ROLE);
            boolean isActive = Boolean.parseBoolean(request.getParameter(FastFoodContants.IS_ACTIVE));
            UserBean user = new UserBUSImp().getUserByUserName(username);
            user.setFirstName(firstname);
            user.setLastName(lastname);
            user.setEmail(email);
            user.setAddress(address);
            user.setPhone(phone);
            user.setRole(role);
            user.setActive(isActive);
            if (new UserBUSImp().update(user)) {
                List<UserBean> allUser = new UserBUSImp().listAll(false);
                if (allUser != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute(FastFoodContants.SESSION_USER, allUser);
                    url = AdminUserList;
                }
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
