/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.controller;

import java.io.IOException;
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

public class LogoutController extends HttpServlet {
	@Override
	// This doGet logs the user activity when the user logs out, invalidates their session and returns them to index.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		DBManager manager = (DBManager) session.getAttribute("manager");

		User user = (User) session.getAttribute("user");
		if (user != null) {
			try {
				manager.addUserActivity(user.getId(), "Logout");
			} catch (Exception e) {
				e.printStackTrace();
			}
			session.invalidate();
		}

		response.sendRedirect("index.jsp");
	}
}
