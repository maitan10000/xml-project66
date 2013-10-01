/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import FastFood.Common.Bean.CategoryBean;
import FastFood.Common.Dao.CategoryDaoImp;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bao
 */
public class TestCategoryDaoController extends HttpServlet {

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
            CategoryDaoImp categoryDao = new CategoryDaoImp();
            //Testadd           
            //categoryDao.Add("coca123");

            //Testupdate
           /* CategoryBean category = new CategoryBean();
            category.setName("pepsi");
            category.setIsActive(true);
            category.setID(2);
            categoryDao.Update(category); */

            //Test Delete
            //categoryDao.Delete(3);

            //Test ListByCATID
           //CategoryBean cat1= categoryDao.ListByCatID(4);
            //System.out.println(cat1.getID());
            //System.out.println(cat1.getName());
            //System.out.println(cat1.isIsActive());

            //Test ListAllCatID

            List<Integer> list = categoryDao.ListAllCatID();
            for(int i=0; i<list.size(); i++){
                System.out.println(list.get(i));
            }

        } finally {
            out.close();
        }
        //testadd

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
