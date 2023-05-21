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
    
    //Adds order
    public void addOrder(int userID, String date) throws SQLException{
        String query = "INSERT INTO ORDERS (USERID, ORDERDATE) VALUES (" + userID + ", '" + date + "')";
        st.executeUpdate(query);
    }
    
    //Adds item into orders cart
    public void addCartItem(int orderID, int productID) throws SQLException{
        String query = "INSERT INTO CART (ORDERID, PRODUCTID) VALUES ("+ orderID +", "+ productID+")";
        st.executeUpdate(query);
    }
    
    //Remove item from orders cart
    public void removeItem(int cartID) throws SQLException{       
        st.executeUpdate("DELETE FROM CART WHERE CARTID=" + cartID + "");
        System.out.print("Item removed from cart!!!");
    }
    
    //Adds deletes all items from cart then deletes order
    public void removeOrder(int orderID) throws SQLException{
        st.executeUpdate("DELETE FROM CART WHERE ORDERID=" + orderID + "");
        System.out.print("Carts dropped!");
    
        st.executeUpdate("DELETE FROM ORDERS WHERE ORDERID=" + orderID + "");
        System.out.print("Order dropped!");
    }
    
    //Cancel order
    public void handleCancelOrder(int userID) throws SQLException{
        String sql = "UPDATE ORDERS SET ACTIVE=FALSE WHERE USERID= "+ userID +"";
        st.executeUpdate(sql);
    }
    
    //Cancel Cart
    public void handleCancelCart(int cartID) throws SQLException{
        String sql = "UPDATE CART SET ACTIVE=FALSE WHERE ORDERID= "+ cartID +"";
        st.executeUpdate(sql);
    }
    
    //Submit order
    public void submit (int orderID) throws SQLException{
        st.executeUpdate("UPDATE ORDERS SET SUBMIT=true WHERE ORDERID=" + orderID + "");
    }
    
    
    //Fetch all saved orders
    public ArrayList<Order> fetchOrders() throws SQLException {
    String fetch = "SELECT * FROM ORDERS WHERE SUBMIT=false";
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
    
    //Fetch all submitted orders
    public ArrayList<Order> fetchSubmittedOrders() throws SQLException {
    String fetch = "SELECT * FROM ORDERS WHERE SUBMIT=true";
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
    
    //Search order by orderID and/or orderDate
    public ArrayList<Order> searchOrder(int orderID, String orderDate, int userID) throws SQLException{
        String fetch;
        if (orderDate == "") {
            fetch = "SELECT * FROM ORDERS WHERE ORDERID=" + orderID + " AND USERID="+ userID +" AND SUBMIT=false";
        } else if (orderID == 0) { //orderID is never 0
            fetch = "SELECT * FROM ORDERS WHERE ORDERDATE='" + orderDate + "' AND USERID="+ userID +" AND SUBMIT=false";
        } else {
            fetch = "SELECT * FROM ORDERS WHERE ORDERDATE='" + orderDate + "' AND ORDERID="+ orderID +" AND USERID="+ userID +" AND SUBMIT=false";
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
    
    //Find cart of order
    public ArrayList<Cart> fetchCart(int orderID) throws SQLException {
        String fetch = "SELECT * FROM CART WHERE ORDERID=" + orderID + "";
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
    
    //Returns list of orders by userID
    public ArrayList<Order> fetchOrdersByUserID(int userID) throws SQLException {
        String fetch = "SELECT * FROM ORDERS WHERE USERID=" + userID + "";
        System.out.print(fetch);
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
    
}


