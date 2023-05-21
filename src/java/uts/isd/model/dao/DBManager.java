/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model.dao;
import uts.isd.model.Payment;

/**
 *
 * @author Andy
 */
import uts.isd.model.User;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import uts.isd.model.UserActivityLog;
import java.sql.Date;

/* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
 */
public class DBManager {

	private Statement st;

	public DBManager(Connection conn) throws SQLException {
		st = conn.createStatement();
	}

	public User findUser(String email, String password) throws SQLException {
		String query = "SELECT * FROM Users WHERE email = ? AND password = ?";
		PreparedStatement st = this.st.getConnection().prepareStatement(query);
		st.setString(1, email);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String role = rs.getString(5);
			return new User(id, name, email, password, role);
		}

		return null;
	}

	public void addUser(String name, String email, String password, String role) throws SQLException {
		String query = "INSERT INTO Users (name, email, password, role) VALUES (?, ?, ?, ?)";
		PreparedStatement st = this.st.getConnection().prepareStatement(query);
		st.setString(1, name);
		st.setString(2, email);
		st.setString(3, password);
		st.setString(4, role);
		st.executeUpdate();
	}

	public void addUserActivity(int userId, String activityType) throws SQLException {
		String sql = "INSERT INTO UserActivityLog(user_id, activity_type) VALUES (?, ?)";
		PreparedStatement st = this.st.getConnection().prepareStatement(sql);
		st.setInt(1, userId);
		st.setString(2, activityType);
		st.executeUpdate();
	}

	public void updateUser(User user) throws SQLException {
		String query = "UPDATE Users SET name = ?, email = ?, password = ? WHERE id = ?";
		PreparedStatement st = this.st.getConnection().prepareStatement(query);
		st.setString(1, user.getName());
		st.setString(2, user.getEmail());
		st.setString(3, user.getPassword());
		st.setInt(4, user.getId());
		st.executeUpdate();
	}

	public List<UserActivityLog> getUserActivityLogs(int userId, Date startDate, Date endDate) throws SQLException { // Change here
		String sql = "SELECT * FROM UserActivityLog WHERE user_id = ? AND date BETWEEN ? AND ?";
		PreparedStatement st = this.st.getConnection().prepareStatement(sql);
		st.setInt(1, userId);
		st.setDate(2, startDate);
		st.setDate(3, endDate);
		ResultSet rs = st.executeQuery();
		List<UserActivityLog> logs = new ArrayList<>();

		while (rs.next()) {
			int id = rs.getInt("id");
			int user_id = rs.getInt("user_id");
			String activityType = rs.getString("activity_type");
			Date date = rs.getDate("date");
			logs.add(new UserActivityLog(id, user_id, activityType, date));
		}

		return logs;
	}
        
        
//======================================= CRUD OPERATIONS FOR PAYMENT MANAGEMENT SECTION  ================================================================//
       
        //get paymentId -- used in payment.java
        public int getPaymentId() throws SQLException {
            int paymentId;
            String fetch = "SELECT MAX(PAYMENTID) FROM Payments" ;
            ResultSet rs = st.executeQuery(fetch);
            if (rs.next()) {
                 paymentId = rs.getInt(1);
                 return paymentId;
            } else {
                return 0;
            }
        }
        
        //Search for paymentId in database
            //Add orderID later
        public Payment searchPaymentId(Integer paymentId) throws SQLException {
            String query = "SELECT * FROM Payments WHERE payment_id = ?";
            PreparedStatement st = this.st.getConnection().prepareStatement(query);
            st.setInt(1, paymentId);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                //Integer orderId = rs.getInt(2);
                String paymentMethod = rs.getString(3);
                String cardNumber = rs.getString(4);
                String cardName = rs.getString(5);
                String expiryDate = rs.getString(6);
                Integer cvv = rs.getInt(7);
                String datePaid = rs.getString(8);
                return new Payment(paymentMethod, cardNumber, cvv, cardName, expiryDate, datePaid);
            }

            return null;
        }
        
        
        //Add user payment info into database
            //Add orderID later
        public void addPayment(String paymentMethod, String cardNumber, Integer cvv, String cardName, String expiryDate, String datePaid) throws SQLException {
                String query = "INSERT INTO Payments (payment_id, order_id, payment_method, card_number, cvv, card_name, expiry_date, date_paid) VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement st = this.st.getConnection().prepareStatement(query);
                //st.setInt(1, OrderId);
                st.setString(2, paymentMethod);
                st.setString(3, cardNumber);
                st.setString(4, cardName);
                st.setString(5, expiryDate);
                st.setInt(6, cvv);
                st.setString(7, datePaid);
                st.executeUpdate();
        }
        
        //Update user payment info into database 
        public void updatePayment(Integer paymentId, String paymentMethod, String cardNumber,
            Integer cvv, String cardName, String expiryDate, String datePaid) throws SQLException {
            String query = "UPDATE Payments SET paymentmethod=?, card_number=?, cvv=?, card_name=?, expiry_date=?, date_paid=? WHERE paymentId=?";
            PreparedStatement st = this.st.getConnection().prepareStatement(query);
            st.setString(1, paymentMethod);
            st.setString(2, cardNumber);
            st.setString(3, cardName);
            st.setString(4, expiryDate);
            st.setInt(5, cvv);
            st.setString(6, datePaid);
            st.setInt(7, paymentId);
            st.executeUpdate();
        }

        
        //Delete payment from database
        public void deletePayment(int paymentId) throws SQLException {
                String query = "DELETE FROM Payments WHERE payment_id = ?";
                PreparedStatement st = this.st.getConnection().prepareStatement(query);
                st.setInt(1, paymentId);
                st.executeUpdate();
        }       
        
        //Display list of payments for user -- used in paymentHistory.jsp
        
        
}
