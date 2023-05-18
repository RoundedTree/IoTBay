/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model.dao;

/**
 *
 * @author Andy
 */

import uts.isd.model.User;
import java.sql.*;
import java.util.ArrayList;

/* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
*/

public class DBManager {

private Statement st;
   
public DBManager(Connection conn) throws SQLException {       
   st = conn.createStatement();   
}

//Find user by email and password in the database   
//public User findUser(String email, String password) throws SQLException {  
//   //setup the select sql query string       
//   String fetch = "select * from ISDUSER.USERS where EMAIL='" + email + "' and PASSWORD= '" + password + "'";
//   //execute this query using the statement field       
//   ResultSet rs = st.executeQuery(fetch);
//   //add the results to a ResultSet       
//   while (rs.next()) {
//       String userEmail = rs.getString(2);
//       String userPass = rs.getString(3);
//       if (userEmail.equals(email) && userPass.equals(password)) {
//           String userName = rs.getString(1);
//           String userGender = rs.getString(4);
//           String userFavcol = rs.getString(5);
//           return new User(userName, userEmail, userPass, userGender, userFavcol);
//       }
//   }
//   //search the ResultSet for a user using the parameters               
//   return null;   
//}
//
////Add a user-data into the database   
//public void addUser(String email, String name, String password, String gender, String favcol) throws SQLException {                   //code for add-operation       
//  st.executeUpdate("INSERT INTO ISDUSER.USERS " + "VALUES ('" + name + "', '" + email + "', '" + password + "', '" + gender + "', '" + favcol + "')");   
//
//}
//
////update a user details in the database   
//public void updateUser( String email, String name, String password, String gender, String favcol) throws SQLException {       
//   //code for update-operation  
//   st.executeUpdate("UPDATE ISDUSER.USERS SET NAME='" + name + "', EMAIL='" + email + "', PASSWORD='" + password + "', GENDER='" + gender + "', FAVCOL='" + favcol + "' WHERE EMAIL='" + email + "'");    
//
//}       
//
////delete a user from the database   
//public void deleteUser(String email) throws SQLException{       
//   //code for delete-operation   
//   st.executeUpdate("DELETE FROM ISDUSER.USERS WHERE EMAIL='" + email + "'");
//
//}
//
//public ArrayList<User> fetchUsers() throws SQLException {
//    String fetch = "SELECT * FROM ISDUSER.USERS";
//    ResultSet rs = st.executeQuery(fetch);
//    ArrayList<User> temp = new ArrayList();
//    
//    while (rs.next()) {
//        String name = rs.getString(1);
//        String email = rs.getString(2);
//        String password = rs.getString(3);
//        String gender = rs.getString(4);
//        String favcol = rs.getString(5);
//        temp.add(new User(name, email, password, gender, favcol));
//    }
//    return temp;
//}
//
//public boolean checkUser (String email, String password) throws SQLException {
//    String fetch = "SELECT * FROM ISDUSER.USERS WHERE EMAIL='" + email + "' AND PASSWORD='" + password + "'";
//    ResultSet rs = st.executeQuery(fetch);
//    
//    while(rs.next()) {
//        String userEmail = rs.getString(2);
//        String userPassword = rs.getString(3);
//        if (userEmail.equals(email) && userPassword.equals(password)) {
//            return true;
//        }
//    }
//    return false;
//}


 

}