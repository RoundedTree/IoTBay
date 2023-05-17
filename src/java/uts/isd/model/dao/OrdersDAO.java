/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import uts.isd.model.Order;
import java.util.Date;
import uts.isd.model.Cart;

/**
 *
 * @author Andy
 */
public class OrdersDAO {
    private Statement st;
    
    public OrdersDAO(Connection conn) throws SQLException { 
    st = conn.createStatement(); 
    }
    
    public ArrayList<Order> fetchOrders() throws SQLException {
    String fetch = "SELECT * FROM ISDUSER.ORDERS";
    ResultSet rs = st.executeQuery(fetch);
    ArrayList<Order> temp = new ArrayList();
    
    while (rs.next()) {
        int id = rs.getInt(1);
        int userId = rs.getInt(2);
        Date date = rs.getDate(3);
        double total = rs.getDouble(4);
        temp.add(new Order(id, userId, date, total));
    }
    return temp;
}
    
    public ArrayList<Cart> fetchCart(int orderID) throws SQLException {
        String fetch = "SELECT * FROM ISDUSER.CART WHERE ORDERID=" + orderID + " ";
        System.out.print(fetch);
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Cart> temp = new ArrayList();
        while (rs.next()) {
        int id = rs.getInt(1);
        int productID = rs.getInt(2);
        temp.add(new Cart(id, productID));
    }
    return temp;
        
    }
    
}
