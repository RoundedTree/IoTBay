/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model;
import java.util.Date;
/**
 *
 * @author Pluuskie
 */
public class Order {
    
    private int orderID;
    private int userID;
    private Date orderDate;
    private boolean submit;
    boolean active;
    
    
    public Order(int orderID, int userID, Date orderDate, boolean submit, boolean active) {
        this.orderID = orderID;
        this.userID = userID;
        this.orderDate = orderDate;
        this.submit = submit;
        this.active = active;
    }

    public boolean isSubmit() {
        return submit;
    }

    public void setSubmit(boolean submit) {
        this.submit = submit;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

	
}
