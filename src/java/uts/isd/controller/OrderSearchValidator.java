/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andy
 */
public class OrderSearchValidator {
    
    private SimpleDateFormat format;
    
    public boolean validateDate(String date) {
        format = new SimpleDateFormat("MM/dd/yyyy");
            format.setLenient(false);
            try {
                format.parse(date);
                System.out.print("Valid date!");
                return true;
            } catch (ParseException e) {
                System.out.print("Not a valid date!");
                return false;
            }
    }
    
    public boolean validateString(String field) {
        return field.isEmpty();
    }
    
    public boolean validateID(String id) {
            try {
                Integer.parseInt( id );
                return true;
            }
            catch( Exception e ) {
                return false;
            }
    }
    
    public void clear(HttpSession session) {
        session.setAttribute("orderSearchErrID", null);
        session.setAttribute("orderSearchErrDate", null);
    }
    
}
