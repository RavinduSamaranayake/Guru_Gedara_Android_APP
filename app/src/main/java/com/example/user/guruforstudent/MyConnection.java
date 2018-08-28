package com.example.user.guruforstudent;

/**
 * Created by USER on 8/13/2018.
 */
import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
public class MyConnection {
    public static Connection getconnection(){

        Connection con = null;
        try{
            StrictMode.ThreadPolicy policy = new  StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://192.168.8.102:3306/gurugedara","kushan","13579");
            System.out.print("Connected......................");
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return con;
    }
}