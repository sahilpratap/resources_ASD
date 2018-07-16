package com.ultron.sahilpratap.delhigovermentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button b1;
    EditText e1;
    TextView t1;

    Calendar cl = Calendar.getInstance();
    int year = cl.get(Calendar.YEAR);
    int month = cl.get(Calendar.MONTH);
    int day = cl.get(Calendar.DAY_OF_MONTH);
    //int day = 17;
  //  String str = Integer.toString(month);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.button);
        e1 = findViewById(R.id.editText);
        t1 = findViewById(R.id.textView);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String number = e1.getText().toString();
               int x = e1.length();
                int n = Integer.parseInt(number);

          if(x == 4) {

                       if ((n%2 == 0 && day <=15) || (n%2 == 1 && day>15)) {
                                t1.setText("" + "you can go to Delhi");
                              //Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();

                                }else
                                     t1.setText("" + "you can't go to Delhi");

          }else

              e1.setError("Pleas enter valid number");

                e1.setText("");
            }

        });
        e1.setText("");
    }
}
