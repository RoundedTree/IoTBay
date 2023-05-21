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
import uts.isd.model.Customer;
import uts.isd.model.dao.CustomerDAO;
import uts.isd.model.dao.DB;

/**
 *
 * @author aucyn
 */
public class CustomerCreateController extends HttpServlet {
    private CustomerDAO customerDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        customerDAO = new CustomerDAO(DB.getConnection());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String customerName = request.getParameter("customerName");
        String customerEmail = request.getParameter("customerEmail");
        String customerType = request.getParameter("customerType");
        String customerAddress = request.getParameter("customerAddress");
        boolean isActive = Boolean.parseBoolean(request.getParameter("isActive"));

        Customer customer = new Customer(customerName, customerEmail, customerType, customerAddress, isActive);

        customer.setCustomerName(customerName);
        customer.setCustomerEmail(customerEmail);
        customer.setCustomerType(customerType);
        customer.setCustomerAddress(customerAddress);
        customer.setActive(isActive);

        customerDAO.createCustomer(customer);

    }
}
