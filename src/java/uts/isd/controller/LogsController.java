/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.User;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author Pluuskie
 */

public class LogsController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		DBManager manager = (DBManager) session.getAttribute("manager");
		User user = (User) session.getAttribute("user");

		if (user != null) {
			try {
				List<String> logs = manager.getUserActivityLogs(user.getId());
				request.setAttribute("logs", logs);
				request.getRequestDispatcher("logs.jsp").forward(request, response);
			} catch (SQLException ex) {
				throw new ServletException(ex);
			}
		} else {
			response.sendRedirect("login.jsp");
		}
	}
}
