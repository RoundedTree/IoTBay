/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.controller;

/**
 *
 * @author Andy
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.dao.*;
import uts.isd.model.*;

public class ConnServlet extends HttpServlet {

	private DBConnector db;
	private DBManager manager;
	private Connection conn;
	private OrdersDAO orders;
	private ArrayList<Order> orderList;

	@Override //Create and instance of DBConnector for the deployment session

	public void init() {
		System.out.println("ConnServlet init");
		try {
			db = new DBConnector();
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override //Add the DBConnector, DBManager, Connection instances to the session

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("DoGet called");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();

		conn = db.openConnection();

		try {

			manager = new DBManager(conn);
			orders = new OrdersDAO(conn);
			orderList = orders.fetchOrders();

		} catch (SQLException ex) {

			Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
		}

		//export the DB manager to the view-session (JSPs)
		session.setAttribute("manager", manager);
		session.setAttribute("orders", orders);
		session.setAttribute("orderList", orderList);

		//Temporary hardcoded userID for order management. Remove when Users object fully implemented
		int id = 100;
		session.setAttribute("tempUserid", id);

	}

	@Override //Destroy the servlet and release the resources of the application (terminate also the db connection)

	public void destroy() {

		try {

			db.closeConnection();

		} catch (SQLException ex) {

			Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

}
