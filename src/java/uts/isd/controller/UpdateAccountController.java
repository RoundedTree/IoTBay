/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.controller;
import uts.isd.model.User;
import uts.isd.model.dao.DBManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pluuskie
 */

public class UpdateAccountController extends HttpServlet {
    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    DBManager manager = (DBManager) session.getAttribute("manager");
    User user = (User) session.getAttribute("user");

    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    if (!name.isEmpty()) {
        user.setName(name);
    }

    if (!email.isEmpty()) {
        user.setEmail(email);
    }

    if (!password.isEmpty()) {
        user.setPassword(password);
    }

    try {
        manager.updateUser(user);
    } catch (SQLException e) {
    }

    session.setAttribute("user", user);
    request.getRequestDispatcher("account.jsp").forward(request, response);
}

}

