package com.example.sahilpratap.textdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i = getIntent();
          TextView u = (TextView) findViewById(R.id.user);
          TextView p = (TextView) findViewById(R.id.pass);
          u.setText(i.getStringExtra("username"));
          p.setText(i.getStringExtra("password"));
   //    Log.i("userName",i.getStringExtra("username"));
   //    Log.i("passWord",i.getStringExtra("password"));

    }
}
