/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model;

import java.sql.Date;

/**
 *
 * @author Thomas
 */

public class UserActivityLog {
	private int id;
	private int userId;
	private String activityType;
	private Date date;

	public UserActivityLog(int id, int userId, String activityType, Date date) {
		this.id = id;
		this.userId = userId;
		this.activityType = activityType;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public Date getDate() {
		return date;
	}

	public void setTimestamp(Date date) {
		this.date= date;
	}
}

