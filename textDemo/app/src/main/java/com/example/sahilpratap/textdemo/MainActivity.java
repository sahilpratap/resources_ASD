package com.example.sahilpratap.textdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public void loginInfo(View view){

        EditText userName = (EditText) findViewById(R.id.usernameEditText);
        EditText password = (EditText) findViewById(R.id.passwordEditText);
        String s1 = userName.getText().toString();
        String s2 = password.getText().toString();
        Intent i = new Intent(getApplicationContext(), Main2Activity.class);
        i.putExtra("username",s1);
        i.putExtra("password",s2);
        startActivity(i);


    //    Log.i("username",userName.getText().toString());
    //    Log.i("password",password.getText().toString());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
