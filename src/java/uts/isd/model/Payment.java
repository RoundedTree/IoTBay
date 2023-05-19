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
    //private String paymentMethod;
    private Integer cardNumber;
    private Integer cvv;
    private String cardName;
    private String expiryDate;
    
    private String datePaid;
    
    // constructor initialies the fields
    public Payment(Integer cardNumber, Integer cvv, String cardName, String expiryDate,  String datePaid) {
        //this.paymentMethod = paymentMethod;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.cardName = cardName;
        this.expiryDate = expiryDate;
        this.datePaid = datePaid;
    }
    
    
    public Payment() {}
    
    /*
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    */
    
    
    public Integer getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(Integer cardNumber) {
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
    
    
     public Integer getCvv() {
        return cvv;
    }
    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }
    
    
     public String getDatePaid() {
        return datePaid;
    }
    public void setDatePaid(String datePaid) {
        this.datePaid = datePaid;
    }
}