package com.ultron.sahilpratap.dynamicfeilds;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ConstraintLayout cl = findViewById(R.id.kuchhbhi);

        EditText e1 = new EditText(MainActivity.this);
        e1.setTextSize(20);
        e1.setHint("Enter your Name");
       int i =0 ;
       e1.setBackgroundColor(i);
        ConstraintLayout.LayoutParams p = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
      p.setMargins(25,25,25,25);
        p.width = 1000;
        p.bottomToBottom
        e1.setLayoutParams(p);
        cl.addView(e1);

    }
}
