/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import FastFood.Common.Bean.ProductBean;
import FastFood.Common.Dao.ProductDaoImp;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Integer;
import java.util.List;
import javax.crypto.interfaces.PBEKey;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bao
 */
public class TestProductDaoController extends HttpServlet {
   
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
            ProductDaoImp ProductDao = new ProductDaoImp();

            //Addproduct
           /* ProductBean pb = new ProductBean();
            pb.setName("GANUONG");
            pb.setPrice(50000);
            pb.setCateID(2);
            pb.setDescription("asdasfwa");
            pb.setImage("asfasf");
            pdi.Add(pb); */

            //UpdateProduct
           /* ProductBean pb1 = new ProductBean();
            pb1.setID(4);
            pb1.setName("GAluoc");
            pb1.setCateID(1);
            pb1.setImage("safaaa");
            pb1.setDescription("312");
            pb1.setBuyCount(8);
            pdi.Update(pb1); */
            
            //DeleteProduct
            //pdi.Delete(5);
            //asa
            //ListbyId

          /*  ProductBean pb3 = ProductDao.ListByProductID(3);
            System.out.println(pb3.getID());
            System.out.println(pb3.getName());
            System.out.println(pb3.getPrice());
            System.out.println(pb3.getLastUpdate());
            System.out.println(pb3.getCateID()); */


           // ListAllID

           /*  List<Integer> list = ProductDao.ListAllProductID();
            for(int i=0; i<list.size(); i++){
                System.out.println(list.get(i));
            }*/

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
