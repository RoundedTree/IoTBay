/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.User;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author Thomas
 */
public class LoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		DBManager manager = (DBManager) session.getAttribute("manager");

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		// This just validates the user based on their email and password using data from the database.
		// And logs them in if it's correct and doesn't otherwise, and provides an error message.
		try {
			User user = manager.findUser(email, password);

			if (user != null) {
				if ("cancelled".equals(user.getAccountStatus())) {
					request.setAttribute("errorInfo", "This account has been cancelled!");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				} else {
					session.setAttribute("user", user);
					manager.addUserActivity(user.getId(), "Login");
					request.getRequestDispatcher("main.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("errorInfo", "Invalid email or password!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}

		} catch (SQLException ex) {
			Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
