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
}