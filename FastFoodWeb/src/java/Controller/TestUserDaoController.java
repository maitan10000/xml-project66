/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import FastFood.Common.Bean.UserBean;
import FastFood.Common.Dao.UserDaoImp;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Everything
 */
public class TestUserDaoController extends HttpServlet {
   
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
            UserDaoImp userDaoImp = new UserDaoImp();

            /*Test add*/
            /*UserBean user = new UserBean();
            user.setUserName("test4");
            user.setPassword("123");
            user.setFirstName("Nguyen Van");
            user.setLastName("D");
            user.setEmail("test4@gmail.com");
            user.setAddress("HCM");
            user.setPhone("123456789");

            userDaoImp.Add(user);*/

            /*UserBean user = new UserBean();
            user.setUserName("test4");
            user.setPassword("123");
            user.setFirstName("Nguyen Van");
            user.setLastName("D");
            user.setEmail("test4@gmail.com");
            user.setAddress("Ha Noi");
            user.setPhone("123456789");
            user.setRole("admin");
            user.setActive(true);
            userDaoImp.Update(user);*/

            //userDaoImp.Delete("test4");

            /*UserBean user = userDaoImp.ListByUserName("admin1");
            System.out.println(user.getUserName());
            System.out.println(user.getPassword());
            System.out.println(user.getFirstName());
            System.out.println(user.getLastName());
            System.out.println(user.getAddress());
            System.out.println(user.getPhone());
            System.out.println(user.getRole());
            System.out.println(user.getCreateDate());
            System.out.println(user.isActive());*/

            List<String> listUser = userDaoImp.ListAllUserName();
            for(int i = 0; i < listUser.size();i++)
            {
                System.out.println(listUser.get(i));
            }


            
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
