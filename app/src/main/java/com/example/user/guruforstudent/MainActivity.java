package com.example.user.guruforstudent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button nxtpg1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nxtpg1=(Button)findViewById(R.id.btnIns);
        nxtpg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginpg();
            }
        });


    }
    public void openLoginpg() {
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }
}
