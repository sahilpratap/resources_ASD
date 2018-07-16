package com.ultron.sahilpratap.dynamicfeilds;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ConstraintLayout cl = findViewById(R.id.layout);

        EditText e1 = new EditText(MainActivity.this);
        e1.setTextSize(20);
        e1.setHint("Enter your Name");
        ConstraintLayout.LayoutParams p = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        p.setMargins(25,25,25,25);
        e1.setLayoutParams(p);
        cl.addView(e1);



    }
}
