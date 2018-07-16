package com.ultron.sahilpratap.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox r1,r2,r3,r4;
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r1 = findViewById(R.id.checkBox);
        r2 = findViewById(R.id.checkBox2);
        r3 = findViewById(R.id.checkBox3);
        r4 = findViewById(R.id.checkBox4);
        b1 = findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String op1 = "",op2 ="",op3 ="",op4="";

                if(r1.isChecked())
                    op1 = r1.getText().toString();
                if (r2.isChecked())
                    op2 = r2.getText().toString();
                if (r3.isChecked())
                    op3 = r3.getText().toString();
                if (r4.isChecked())
                    op2 = r4.getText().toString();
                Toast.makeText(getApplicationContext(),""+op1+op2+op3+op4,Toast.LENGTH_LONG).show();

            }
        });
    }
}
