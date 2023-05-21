package uts.isd.model.dao;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author admin
 */
import uts.isd.model.*;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.Date;
public class ProductDBManager {
    private Statement st;
    
    public ProductDBManager(Connection conn) throws SQLException {
	st = conn.createStatement();
    }
    
    public Product findProduct(int id, String name) throws SQLException {
		String fetch = "SELECT * FROM  USERDB.Product WHERE id =? AND name=?";
		ResultSet rs = st.executeQuery(fetch);

		while (rs.next()) {
			int productID = rs.getInt(1);
			String productName = rs.getString(2);
			if((productID ==id) && productName.equals(name)){
                            String productType = rs.getString(3);
                            double productPrice = rs.getDouble(4);
                            int productQuantity = rs.getInt(5);
                            return new Product(productID, productName, productType, productPrice,productQuantity);
                            
                        }
		
		}
		return null;
    }
    
    public void addProduct(int id, String name, String type, double price, int quantity) throws SQLException{
                st.executeUpdate("INSERT INTO USERDB.Product"+ "VALUES(id,'"+name+",'"+type+"',price,quantity)");
    }
    
    public void updatePrice(int id, String name, double price) throws SQLException{
        st.executeUpdate("UPDATE USERDB.Product SET PRICE='" + price+ "' WHERE PRODUCTID=id AND NAME='"+name+"' ");
    }
    
    public void updateQuantity(int id, String name,  int quantity) throws SQLException{
        st.executeUpdate("UPDATE USERDB.Product SET QUANTITY='" + quantity+ "' WHERE PRODUCTID=id AND NAME='"+name+"' ");
    }  
    
    public void deleteProduct(int id, String name) throws SQLException{
        st.executeUpdate("DELETE FROM USERDB.Product  WHERE PRODUCTID=id AND NAME='"+name+"' ");
    }
    
    
    public ArrayList<Product> fetchProducts() throws SQLException{
        String fetch = "SELECT * FROM PRODUCT";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Product> temp = new ArrayList();
        while(rs.next()){
            int productID = rs.getInt(1);
            String productName = rs.getString(2);
            String productType = rs.getString(3);
            double productPrice = rs.getDouble(4);
            int productQuantity = rs.getInt(5);
            temp.add(new Product(productID,productName,productType,productPrice,productQuantity));
        }
        return temp;
    }
    
    public ArrayList<Product> findProducts( String name) throws SQLException{
        String fetch = "SELECT * FROM PRODUCT WHERE  NAME='"+name+"'";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Product> temp = new ArrayList();
        while(rs.next()){
            int productID = rs.getInt(1);
            String productName = rs.getString(2);
            String productType = rs.getString(3);
            double productPrice = rs.getDouble(4);
            int productQuantity = rs.getInt(5);
            temp.add(new Product(productID,productName,productType,productPrice,productQuantity));
        }
        return temp;
    }
    
    
    
}
