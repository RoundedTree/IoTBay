/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.controller;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class AddOrderController  extends HttpServlet {
    
    private SimpleDateFormat simpleDateFormat;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        OrdersDAO ordersDao = (OrdersDAO) session.getAttribute("orders");
        try{
            String userID = (request.getParameter("userID"));
            simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
            
            String dateSring = simpleDateFormat.format(new Date());
            int id = parseInt(userID);
            
            System.out.print(userID);
            System.out.print(dateSring);
            System.out.print("Adding order");
            ordersDao.addOrder(id, dateSring);
            
            //Update OrderList
            System.out.print("Updating orders");
            ArrayList<Order> orderList = ordersDao.fetchOrders();
            session.setAttribute("orderList", orderList);
            
            System.out.print("Finishing?");
            request.getRequestDispatcher("main.jsp").include(request, response);
        } catch(SQLException ex) {
            
        }
    }
}
