/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.controller;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        HttpSession session = request.getSession();
        OrdersDAO ordersDao = (OrdersDAO) session.getAttribute("orders");
        OrderSearchValidator validate = new OrderSearchValidator();
        
        try {
            ArrayList<Order> temp = new ArrayList();
            String searchID = (request.getParameter("searchID"));
            String searchDate = (request.getParameter("searchDate"));
            String user = (request.getParameter("userID"));
            int userId = parseInt(user);
            //Clearing error attributes
            validate.clear(session);
            int id = 0;
            if (!validate.validateID(searchID) && !validate.validateString(searchID)) {
                session.setAttribute("orderSearchErrID", "Invalid orderID number entered!");
            }  else if (!validate.validateString(searchID)){
                id = parseInt(searchID);
            }
            if(!validate.validateDate(searchDate) && !validate.validateString(searchDate)) {
                session.setAttribute("orderSearchErrDate", "Invalid date entered!");
                searchDate = "";
            }
            
            temp = ordersDao.searchOrder(id,  searchDate, userId);
            session.setAttribute("searchedOrders", temp);
            request.getRequestDispatcher("orderSearch.jsp").include(request, response);
        } catch(SQLException ex) {
            Logger.getLogger(OrderSearchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

