/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import uts.isd.model.User;

/**
 *
 * @author Thomas
 */
public class AccountController extends HttpServlet {
	// This just sets the attributes when the AccountController is called by the button on the header.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		req.setAttribute("user", user);
		req.getRequestDispatcher("/account.jsp").forward(req, resp);
	}
}
