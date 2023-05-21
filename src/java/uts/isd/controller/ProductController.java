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
import uts.isd.model.dao.ProductDBManager;

/**
 *
 * @author admin
 */

public class ProductController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
            ProductDBManager manager = (ProductDBManager) session.getAttribute("manager");

            int id = Integer.parseInt(request.getParameter("id")) ;
            String name = request.getParameter("name");
            String type = request.getParameter("type");
            double price = Double.parseDouble(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity")) ;
            
        try {
            manager.addProduct(id,name, type, price,quantity);
            request.getRequestDispatcher("product.jsp").forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("errorInfo", "Error during Product creation. Please try again.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
