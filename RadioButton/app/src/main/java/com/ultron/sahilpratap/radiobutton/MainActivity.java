package com.ultron.sahilpratap.radiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton r1,r2;
    Button b1;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r1 = findViewById(R.id.radio1);
        r2 = findViewById(R.id.radio2);
        b1 = findViewById(R.id.button);
        b1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if(r1.isChecked())
                    result = r1.getText().toString();
                else if(r2.isChecked())
                    result = r2.getText().toString();
                else
                    result = "";
                    Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
