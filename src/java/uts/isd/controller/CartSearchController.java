/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.controller;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Cart;
import uts.isd.model.dao.OrdersDAO;

/**
 *
 * @author Andy
 */
public class CartSearchController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        OrdersDAO ordersDao = (OrdersDAO) session.getAttribute("orders");
        try{
            ArrayList<Cart> temp = new ArrayList();
            int id;
            String i = (request.getParameter("orderID"));
            id = parseInt(i);
            temp = ordersDao.fetchCart(id);
            session.setAttribute("cartItems", temp);
            request.getRequestDispatcher("viewOrder.jsp").include(request, response);
        } catch(SQLException ex) {
            
        }
        
    }
}
