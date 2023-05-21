/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.controller;

import uts.isd.model.Payment;
import uts.isd.model.dao.DBManager;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author angelaliang
 */
public class EditPaymentController {
    
  
    //@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // establish session 
        HttpSession session = request.getSession();
        Integer paymentId = Integer.parseInt(request.getParameter("paymentId"));
        DBManager manager = ( DBManager) session.getAttribute("manager");
        
        Payment payment = null;
        try{
            //find paymnetId to edit payment details
            payment = manager.searchPaymentId(paymentId);
            System.out.println(paymentId);
            if(payment != null){
                session.setAttribute("payment", payment);
                request.getRequestDispatcher("confirmPayment.jsp").include(request, response);
                response.sendRedirect("updatePayment.jsp");
            } else {
                //error message
                session.setAttribute("existErr", "Payment does not exist in database");
                request.getRequestDispatcher("Payment_Update.jsp").include(request, response);
            }
        } catch (SQLException ex) {
           System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
        }
    }  
    
}
