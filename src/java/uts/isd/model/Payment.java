/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//Payment is a Javabean that stores Users credit card details the cardNumber, Name on card , Expiry date and CVV
package uts.isd.model;
import java.io.Serializable;

/**
 *
 * @author angelaliang
 */
public class Payment implements Serializable{
    private String paymentMethod;
    private String cardNumber;
    private int cvv;
    private String cardName;
    private String expiryDate;
   
    private String datePaid;
    
    // constructor initialies the fields
    public Payment(String cardName, String cardNumber, Integer cvv, String expiryDate, String datePaid, String paymentMethod) {
        //this.paymentMethod = paymentMethod;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.cardName = cardName;
        this.expiryDate = expiryDate;
        this.datePaid = datePaid;
        this.paymentMethod = paymentMethod;
    }
    
  //getters and setters for Payment Management  
    
    public Payment() {}
    
    
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
   
    
    
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    
    public String getCardName() {
        return cardName;
    }
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    
    public String getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
    
    
     public int getCvv() {
        return cvv;
    }
    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
    
    
     public String getDatePaid() {
        return datePaid;
    }
    public void setDatePaid(String datePaid) {
        this.datePaid = datePaid;
    }
}