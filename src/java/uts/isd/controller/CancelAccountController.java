/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Order;
import uts.isd.model.User;
import uts.isd.model.dao.DBManager;
import uts.isd.model.dao.OrdersDAO;

/**
 *
 * @author Thomas
 */
public class CancelAccountController extends HttpServlet {
	// This sets the user's account to cancelled status when it's called.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		DBManager manager = (DBManager) session.getAttribute("manager");
                OrdersDAO ordersDao = (OrdersDAO) session.getAttribute("orders");
                
		User user = (User) session.getAttribute("user");

		try {
			manager.cancelUserAccount(user.getId());
                        ordersDao.handleCancelOrder(user.getId());
                        
                        ArrayList<Order> cancel = new ArrayList<Order>();
                        cancel = ordersDao.fetchOrdersByUserID(user.getId());
                        for (Order order : cancel) {
                            ordersDao.handleCancelCart(order.getOrderID());
                        }
                        
                        
			session.invalidate();
			response.sendRedirect("index.jsp");
		} catch (SQLException e) {
			throw new ServletException("Cannot cancel user account", e);
		}
	}
}
