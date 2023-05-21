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
import uts.isd.model.dao.DBManager;

/**
 *
 * @author Pluuskie
 */
public class RegisterController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		DBManager manager = (DBManager) session.getAttribute("manager");

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = "customer";
		String accountStatus = "active";

		try {
			manager.addUser(name, email, password, role, accountStatus);
			request.getRequestDispatcher("login.jsp").forward(request, response);

		} catch (SQLException ex) {
			Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
			request.setAttribute("errorInfo", "Error during registration. Please try again.");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}
}
