package com.example.user.guruforstudent;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Login extends AppCompatActivity {
    Connection con = null;
    PreparedStatement ps = null;
    Button nxtpg2;
    Button nxtregpg;
    EditText username;
    EditText passwd;
    TextView tv;
   // User u = new User();

    @Override





    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        con = MyConnection.getconnection();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        nxtpg2=(Button)findViewById(R.id.login);
        nxtregpg = (Button)findViewById(R.id.regBtn);
        username =(EditText)findViewById(R.id.txtUname);
        passwd =(EditText)findViewById(R.id.txtPasswd);


        nxtpg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = username.getText().toString();
                String paswd = passwd.getText().toString();
               /** int m = u.UserLogin(uname,paswd);
                if(m==1) {
                    Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG).show();
                    openslctclsspg();
                }
                 else if(m==0){
                    Toast.makeText(getApplicationContext(), "Invalid Data", Toast.LENGTH_LONG).show();
                }
                else if(m==2){
                    Toast.makeText(getApplicationContext(), "Login Fail", Toast.LENGTH_LONG).show();
                } **/
                try {
                   /* StrictMode.ThreadPolicy policy = new  StrictMode.ThreadPolicy.Builder().permitAll().build();

                    StrictMode.setThreadPolicy(policy);
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://192.168.8.102:3306/gurugedara","kushan","13579");
                    System.out.print("Connected......................"); */


                    /*String result = "DB conection sucess ";
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM usertable");
                    ResultSetMetaData rsmd = rs.getMetaData();
                    while (rs.next()){
                        result +=  rsmd.getColumnName(1) + " : " + rs.getString(1) + "\n";
                        result +=  rsmd.getColumnName(2) + " : " + rs.getString(2) + "\n";
                        result +=  rsmd.getColumnName(3) + " : " + rs.getString(3) + "\n";
                    }

                    Toast.makeText(getApplicationContext(),result, Toast.LENGTH_LONG).show(); */
                    ps = con.prepareStatement("SELECT * FROM `usertable` WHERE username =? AND password =?");
                    ps.setString(1, uname);
                    ps.setString(2, paswd);
                    ResultSet rs = ps.executeQuery();
                    if(rs.next()){
                        System.out.print("Login Sucess");
                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG).show();
                        openslctclsspg();


                    }
                    else{
                        System.out.print("Login fail");
                        Toast.makeText(getApplicationContext(), "Invalid Data", Toast.LENGTH_LONG).show();

                    }

                } catch (Exception e) {
                    System.out.print(e);
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();

                }
            }
        });
        nxtregpg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openregpg();
            }
        });


    }
    public void openslctclsspg() {
        Intent intent = new Intent(this,Menu.class);
        startActivity(intent);
    }
    public void openregpg() {
        Intent intent = new Intent(this,userRegister.class);
        startActivity(intent);
    }

}
