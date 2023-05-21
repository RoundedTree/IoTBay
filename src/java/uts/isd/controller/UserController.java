/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.controller;

import uts.isd.model.*;
import uts.isd.model.dao.DBManager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Cynthia & Sarneet
 */
public class UserController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		DBManager manager = (DBManager) session.getAttribute("manager");

		String action = request.getParameter("action");
		// loadAdmin makes sure that it initializes the list of users.
		if ("loadAdmin".equals(action)) {
			try {
				List<User> users = manager.getAllUsers();
				session.setAttribute("users", users);
				request.getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
			} catch (SQLException e) {
				throw new ServletException("Cannot get users", e);
			}
		// Search here gets the parameter in the search bar and inputs that into searchUsers, which filters out
		// users with that name.
		} else if ("search".equals(action)) {
			String name = request.getParameter("name");
			try {
				List<User> users = manager.searchUsers(name);
				session.setAttribute("users", users);
				request.getRequestDispatcher("admin.jsp").forward(request, response);
			} catch (SQLException e) {
				throw new ServletException("Cannot get users", e);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String role = request.getParameter("role");
		String accountStatus = request.getParameter("accountStatus") == null ? "active" : request.getParameter("accountStatus");
		String action = request.getParameter("action");
		int id = -1;
		if (!"add".equals(action)) {
			id = Integer.parseInt(request.getParameter("id"));
		}

		DBManager manager = (DBManager) session.getAttribute("manager");
		
		// The following lines all run the DBManager methods based on the action posted.
		if (action.equals("delete")) {
			try {
				manager.deleteUser(id);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} else if (action.equals("update")) {
			try {
				manager.updateUser(id, name, email, password, role, accountStatus);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} else if (action.equals("add")) {
			try {
				manager.addUser(name, email, password, role, accountStatus);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		// This ensures that the full list appears when the search function isn't being used.
		try {
			List<User> users = manager.getAllUsers();
			session.setAttribute("users", users);
			request.getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
