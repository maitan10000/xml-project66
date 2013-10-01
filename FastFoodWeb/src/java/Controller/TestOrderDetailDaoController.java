/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import FastFood.Common.Bean.OrderDetailBean;
import FastFood.Common.Dao.OrderDetailDaoImp;
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
public class TestOrderDetailDaoController extends HttpServlet {

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
            OrderDetailDaoImp ODDao = new OrderDetailDaoImp();

            //AddOrderdetail
           /* OrderDetailBean ODBean = new OrderDetailBean();
            ODBean.setOrderID(6);
            ODBean.setProductID(7);
            ODBean.setPrice(9000);
            ODBean.setQuantity(110);
            ODDao.Add(ODBean); */

            //UpdateOrderDetail
           /* OrderDetailBean ODBean1 = new OrderDetailBean();
            ODBean1.setOrderID(6);
            ODBean1.setProductID(3);
            ODBean1.setPrice(44000);
            ODBean1.setQuantity(21);
            ODDao.Update(ODBean1); */

            //DeleteOrderDetail
            //ODDao.Delete(6, 7);

            //ListOrderDetail
           /* OrderDetailBean pb3 = ODDao.ListByOrderDetailID(6, 3);
            System.out.println(pb3.getOrderID());
            System.out.println(pb3.getProductID());
            System.out.println(pb3.getPrice());
            System.out.println(pb3.getQuantity());*/

            //ListallOrderDetail
             List<Integer[]> list = ODDao.ListAllOrderDetailID();
            for(int i=0; i<list.size(); i++){
                System.out.println(list.get(i)[0]);
                System.out.println(list.get(i)[1]);

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
