package com.example.user.guruforstudent;

import android.content.Intent;
import android.provider.Settings;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by USER on 8/14/2018.
 */

public class User {
    Connection con = null;
    PreparedStatement ps = null;
    String uname;
    String passwd;
    public User(){
        con = MyConnection.getconnection();
    }
    public int UserLogin(String uname,String passwd){
        this.uname = uname;
        this.passwd = passwd;
        try {
            ps = con.prepareStatement("SELECT * FROM `usertable` WHERE username =? AND password =?");
            ps.setString(1, this.uname);
            ps.setString(2, this.passwd);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                System.out.print("Login Sucess");
                 return 1;

            }
            else{
                System.out.print("Login fail");
                return 0;
            }

        } catch (Exception e) {
            System.out.print(e);
            return 2;
        }




    }

}
