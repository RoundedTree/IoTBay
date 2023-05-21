/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
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
public class CancelAccountController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		DBManager manager = (DBManager) session.getAttribute("manager");
		User user = (User) session.getAttribute("user");

		try {
			manager.cancelUserAccount(user.getId());
			session.invalidate();
			response.sendRedirect("index.jsp");
		} catch (SQLException e) {
			throw new ServletException("Cannot cancel user account", e);
		}
	}
}
