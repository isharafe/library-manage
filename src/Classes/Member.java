/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;

/**
 *
 * @author Group 20
 */
public class Member {

    public Member() {
    }

    public Member(String userType, String userName) {
        this.userType = userType;
        this.userName = userName;
    }

    
    
    public String userType;
    public String userName,
            name;
    public char gender;
    public Date dob;
    public String address,
            tp,
            email,
            feedBack,
            password;

    public void reset() {
        userType = "";
        userName = "";
        name = "";
        gender = '!';
        dob = null;
        address = "";
        tp = "";
        email = "";
        feedBack = "";
        password="";
    }
}
