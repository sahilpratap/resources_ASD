package com.ultron.sahilpratap.sms_service;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.editText);
        btn = findViewById(R.id.button);

        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED)
        {

            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},101);


            return;

        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String t = e1.getText().toString();
                String number = "8467090016";


              SmsManager sms =  SmsManager.getDefault();

              sms.sendTextMessage(number,null,t,null,null);
                Toast.makeText(MainActivity.this,"sms Sent..",Toast.LENGTH_LONG).show();
            }
        });


    }
}
