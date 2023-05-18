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
    
    public void removeItem(int cartID) throws SQLException{       
    st.executeUpdate("DELETE FROM ISDUSER.CART WHERE CARTID=" + cartID + "");
    System.out.print("Item removed from cart!!!");
    }
    
    public void removeOrder(int orderID) throws SQLException{
    System.out.print("Test!");
    st.executeUpdate("DELETE FROM ISDUSER.CART WHERE ORDERID=" + orderID + "");
    System.out.print("Carts dropped!");
    
    st.executeUpdate("DELETE FROM ISDUSER.ORDERS WHERE ORDERID=" + orderID + "");
    System.out.print("Order dropped!");
    
    
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
    
    
    public ArrayList<Order> searchOrder(int orderID, String orderDate) throws SQLException{
        String fetch;
        if (orderDate == "") {
            fetch = "SELECT * FROM ISDUSER.ORDERS WHERE ORDERID=" + orderID + " ";
        } else if (orderID == 0) { //orderID is never 0
            fetch = "SELECT * FROM ISDUSER.ORDERS WHERE ORDERDATE='" + orderDate + "'";
        } else {
            System.out.print("SELECT * FROM ISDUSER.ORDERS WHERE ORDERDATE='" + orderDate + "' AND ORDERID="+ orderID +" ");
            fetch = "SELECT * FROM ISDUSER.ORDERS WHERE ORDERDATE='" + orderDate + "' AND ORDERID="+ orderID +" ";
        }
        
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
        int cartID = rs.getInt(1);
        int id = rs.getInt(2);
        int productID = rs.getInt(3);
        temp.add(new Cart(cartID, id, productID));
    }
    return temp;
        
    }
    
}
