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
import uts.isd.model.Order;
import uts.isd.model.dao.OrdersDAO;

/**
 *
 * @author Andy
 */
public class RemoveOrderController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        OrdersDAO ordersDao = (OrdersDAO) session.getAttribute("orders");
        try{
            int id;
            String i = (request.getParameter("orderID"));
            System.out.print(i);
            id = parseInt(i);
            System.out.print(i);
            ordersDao.removeOrder(id);
            System.out.print("Order removed!");
            
            //Update OrderList
            ArrayList<Order> orderList = ordersDao.fetchOrders();
            session.setAttribute("orderList", orderList);
            
            request.getRequestDispatcher("orderManage.jsp").include(request, response);
        } catch(SQLException ex) {
            
        }
    }
    
}
