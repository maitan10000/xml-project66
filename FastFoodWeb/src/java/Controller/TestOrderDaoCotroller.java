/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import FastFood.Common.Bean.OrderBean;
import FastFood.Common.Dao.OrderDaoImp;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//a
/**
 *
 * @author Everything
 */
public class TestOrderDaoCotroller extends HttpServlet {

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
            OrderDaoImp orderDao = new OrderDaoImp();

            //create order
           /*OrderBean order = new OrderBean();
            order.setBuyerName("test1");
            order.setCreator("admin1");
            order.setStatus("NA");
            order.setNotes("NO");
            order.setReceiveAddress("HCM");
            orderDao.Add(order);*/

            //Update
          /* OrderBean order = new OrderBean();
            order.setID(1);
            order.setBuyerName("test1");
            order.setCreator("admin1");
            order.setStatus("NA");
            order.setNotes("NO");
            order.setReceiveAddress("HCM");
            order.setIsActive(true);
            orderDao.Update(order);*/

            //Delete
            //orderDao.Delete(2);

            //ListByID
            /*OrderBean order = orderDao.ListByOrderID(2);
            System.out.println(order.getID());
            System.out.println(order.getBuyerName());
            System.out.println(order.getCreator());
            System.out.println(order.getStatus());
            System.out.println(order.getNotes());
            System.out.println(order.getReceiveAddress());
            System.out.println(order.getCreateDate());
            System.out.println(order.isIsActive());*/

            //ListAllID
            /*List<Integer> listAllID = orderDao.ListAllOrderID();
            System.out.println(listAllID.get(0));
            System.out.println(listAllID.get(1));*/

            //ListAllIDByBuyernName
            List<Integer> listAllID = orderDao.ListAllOrderByBuyer("test1");
            System.out.println(listAllID.size());

            //ListAllIDByCreator
            listAllID = orderDao.ListAllOrderByCreator("admin2");
            System.out.println(listAllID.size());
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
