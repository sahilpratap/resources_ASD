package com.ultron.sahilpratap.firstintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        t1 = findViewById(R.id.textView);
        Bundle bundle = getIntent().getExtras();
       String name = bundle.getString("name key");
       String address = bundle.getString("address key");
       t1.setText(name+"\n"+address);

    }
}
