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
}
