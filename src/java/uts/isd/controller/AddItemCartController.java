/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.controller;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.dao.OrdersDAO;

/**
 *
 * @author Andy
 */
public class AddItemCartController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        OrdersDAO ordersDao = (OrdersDAO) session.getAttribute("orders");
        OrderSearchValidator validate = new OrderSearchValidator();
        try{
            String orderID = (request.getParameter("orderID"));
            String productID = (request.getParameter("productID"));
            
            int id = parseInt(orderID);
            
            
            System.out.print("Updating cart");
            
            if (validate.validateID(productID)) {
                int product = parseInt(productID);
                ordersDao.addCartItem(id, product);
                request.getRequestDispatcher("orderManage.jsp").include(request, response);
            }else {
                request.getRequestDispatcher("orderManage.jsp").include(request, response);
            }
            
        } catch(SQLException ex) {
            
        }
    }
    
}
