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
    
    public void addOrder(int userID, String date) throws SQLException{
        String query = "INSERT INTO ORDERS (USERID, ORDERDATE, ORDERPRICE) VALUES (" + userID + ", '" + date + "', 0)";
        st.executeUpdate(query);
    }
    
    public void addCartItem(int orderID, int productID) throws SQLException{
        String query = "INSERT INTO CART (ORDERID, PRODUCTID) VALUES ("+ orderID +", "+ productID+")";
        st.executeUpdate(query);
    }
    
    public void removeItem(int cartID) throws SQLException{       
        st.executeUpdate("DELETE FROM CART WHERE CARTID=" + cartID + "");
        System.out.print("Item removed from cart!!!");
    }
    
    public void removeOrder(int orderID) throws SQLException{
        st.executeUpdate("DELETE FROM CART WHERE ORDERID=" + orderID + "");
        System.out.print("Carts dropped!");
    
        st.executeUpdate("DELETE FROM ORDERS WHERE ORDERID=" + orderID + "");
        System.out.print("Order dropped!");
    }
    
    public ArrayList<Order> fetchOrders() throws SQLException {
    String fetch = "SELECT * FROM ORDERS";
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
    
    
    public ArrayList<Order> searchOrder(int orderID, String orderDate, int userID) throws SQLException{
        String fetch;
        if (orderDate == "") {
            fetch = "SELECT * FROM ORDERS WHERE ORDERID=" + orderID + " AND USERID="+ userID +"";
        } else if (orderID == 0) { //orderID is never 0
            fetch = "SELECT * FROM ORDERS WHERE ORDERDATE='" + orderDate + "' AND USERID="+ userID +"";
        } else {
            fetch = "SELECT * FROM ORDERS WHERE ORDERDATE='" + orderDate + "' AND ORDERID="+ orderID +" AND USERID="+ userID +"";
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
        String fetch = "SELECT * FROM CART WHERE ORDERID=" + orderID + " ";
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
