package com.ultron.sahilpratap.ragistrationform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class second_activity extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);

        t1 = findViewById(R.id.textView2);
        t2 = findViewById(R.id.textView3);
        t3 = findViewById(R.id.textView4);
        t4 = findViewById(R.id.textView5);
        t5 = findViewById(R.id.textView6);



        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name key");
        String phoneNo = bundle.getString("phone key");
        String subject = bundle.getString("subject key");
        String faculty = bundle.getString("faculty key");
        String gender = bundle.getString("gender key");

        t1.setText("Name: "+name);
        t2.setText("Phone No: "+phoneNo);
        t3.setText("Subject: "+subject);
        t4.setText("Faculty: "+faculty);
        t5.setText("Gender: "+gender);
   //   Toast.makeText(getApplicationContext(),""+name+"\n"+phoneNo+"\n"+subject+"\n"+faculty+"\n"+gender,Toast.LENGTH_LONG).show();




    }
}
