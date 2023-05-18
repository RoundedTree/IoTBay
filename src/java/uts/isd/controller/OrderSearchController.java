/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.controller;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.*;
import uts.isd.model.dao.OrdersDAO;

/**
 *
 * @author Andy
 */
public class OrderSearchController extends HttpServlet  {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.print("first test");
        HttpSession session = request.getSession();
        OrdersDAO ordersDao = (OrdersDAO) session.getAttribute("orders");
        
        try {
            ArrayList<Order> temp = new ArrayList();
            System.out.print("first test");
            // TODO error handling
            String searchID = (request.getParameter("searchID"));
            String searchDate = (request.getParameter("searchDate"));
//            String test = "12/12/2015";
            int id = 0;
            try {
                Integer.parseInt( searchID );
                id = Integer.parseInt( searchID );
            }
            catch( Exception e ) {
                id = 0;
            }
            
            temp = ordersDao.searchOrder(id,  searchDate);
            session.setAttribute("searchedOrders", temp);
            request.getRequestDispatcher("orderSearch.jsp").include(request, response);
        } catch(SQLException ex) {
            Logger.getLogger(OrderSearchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

