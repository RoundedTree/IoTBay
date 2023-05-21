/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.controller;
import uts.isd.model.Payment;
import uts.isd.model.dao.DBManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; 
/** 
 *
 * @author angelaliang
 */

//controller for payments.jsp -- error keeps popping up  <form action="SubmitPaymentController" method="post" >
//set orderID later after composite key (paymentID & orderID) established 

public class SubmitPaymentController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // For Session
         HttpSession session = request.getSession();
         String paymentMethod = request.getParameter("paymentMethod");
         String cardNumber = request.getParameter("cardNumber");
         Integer cvv = Integer.parseInt(request.getParameter("cvv"));
         String cardName = request.getParameter("cardName");
         String expiryDate = request.getParameter("expiryDate");
         String datePaid = request.getParameter("datePaid");     
         
         Payment payment = new Payment(cardName,cardNumber, cvv, expiryDate, datePaid, paymentMethod);
         DBManager manager = (DBManager) session.getAttribute("manager");
        
         try {
             if(payment != null){
                 session.setAttribute("payment", payment);
                 //Integer orderId = manager.getOrderId();
                 //session.setAttribute("orderId", orderId);
                 manager.addPayment(paymentMethod, cardNumber, cvv, cardName, expiryDate, datePaid);
                 Integer paymentId = manager.getPaymentId();
                 session.setAttribute("paymentId", paymentId);
                 request.getRequestDispatcher("payment.jsp").include(request, response);
                 response.sendRedirect("confirmPayment.jsp");
             } else {
                 request.getRequestDispatcher("main.jsp").include(request, response);
             }
         } 
         catch ( SQLException ex){
            // Logger.getLogger(editPayment.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
