package com.example.user.guruforstudent;

/**
 * Created by USER on 8/13/2018.
 */

public class testCon {
    public static void main(String [] args ){
       MyConnection.getconnection();
       String name = "Ravindu95";
       String passwd = "12345";
       User u = new User();
       u.UserLogin(name,passwd);
    }
}
