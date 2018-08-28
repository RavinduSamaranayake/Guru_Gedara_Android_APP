package com.example.user.guruforstudent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class userRegister extends AppCompatActivity {
    EditText fname;
    EditText lname;
    EditText uname;
    EditText passwd;
    EditText conpasswd;
    EditText email;
    Button regbtn;
    Button cancelbtn;
    Connection con = null;
    PreparedStatement ps = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        con = MyConnection.getconnection();
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_user_register);
        fname = (EditText)findViewById(R.id.fname);
        lname = (EditText)findViewById(R.id.lname);
        uname = (EditText)findViewById(R.id.uname);
        passwd = (EditText)findViewById(R.id.passwd);
        conpasswd = (EditText)findViewById(R.id.conpasswd);
        email = (EditText)findViewById(R.id.email);
        regbtn = (Button)findViewById(R.id.regBtn);
        cancelbtn = (Button)findViewById(R.id.cancelBtn);
        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fname.getText().length()==0){
                    Toast.makeText(getApplicationContext(), "Name is Empty", Toast.LENGTH_LONG).show();
                }
                else if(email.getText().length()==0){
                    Toast.makeText(getApplicationContext(), "email is Empty", Toast.LENGTH_LONG).show();
                }
                else if(uname.getText().length()==0){
                    Toast.makeText(getApplicationContext(), "user name is Empty", Toast.LENGTH_LONG).show();
                }
                else if(passwd.getText().length()==0){
                    Toast.makeText(getApplicationContext(), "password is Empty", Toast.LENGTH_LONG).show();
                }
                else if(passwd.getText().length()<8){
                    Toast.makeText(getApplicationContext(), "password is short", Toast.LENGTH_LONG).show();
                }
                else if(passwd.getText().length()>20){
                    Toast.makeText(getApplicationContext(), "password is long", Toast.LENGTH_LONG).show();
                }
                else if(!String.valueOf(passwd.getText()).equals(String.valueOf(conpasswd.getText()))){
                    Toast.makeText(getApplicationContext(), "not match your entered passwords", Toast.LENGTH_LONG).show();
                }


                else{
                    String sid = uname.getText().toString();
                    String finame = fname.getText().toString();
                    String laname = lname.getText().toString();
                    String emai = email.getText().toString();
                    String passwrd = passwd.getText().toString();

                    try {
                        String query = "INSERT INTO `usertable`(`fname`, `lname`, `username`, `password`, `email`) VALUES (?,?,?,?,?)";
                        ps = con.prepareStatement(query);
                        ps.setString(1, finame);
                        ps.setString(2, laname);
                        ps.setString(3, sid);
                        ps.setString(4, passwrd);
                        ps.setString(5, emai);
                        if(ps.executeUpdate()>0){
                            Toast.makeText(getApplicationContext(), "Registration Sueccessfull", Toast.LENGTH_LONG).show();
                            openslctclsspg();
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Registration fail", Toast.LENGTH_LONG).show();
                        }

                    } catch (Exception ex) {
                        //Logger.getLogger(SignupUser.class.getName()).log(Level.SEVERE, null, ex);
                        Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlogpg();
            }
        });


    }
    public void openslctclsspg() {
        Intent intent = new Intent(this,Menu.class);
        startActivity(intent);
    }
    public void openlogpg() {
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }

}

