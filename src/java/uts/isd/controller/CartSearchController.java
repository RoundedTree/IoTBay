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
            System.out.print("test2");
            ArrayList<Cart> temp = new ArrayList();
            int id;
            System.out.print("test3");
            String i = (request.getParameter("editOrderId"));
            System.out.print(i);
            id = parseInt(i);
            System.out.print(id);
            temp = ordersDao.fetchCart(id);
            System.out.print(temp);
            session.setAttribute("cartItems", temp);
            System.out.print("Success???");
            request.getRequestDispatcher("viewOrder.jsp").include(request, response);
        } catch(SQLException ex) {
            
        }
        
    }
}
