package com.ultron.sahilpratap.who;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button b1;
    EditText e1,e2;
    TextView t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.editText);
        e2 = findViewById(R.id.editText2);
        b1 = findViewById(R.id.button);
        t1 = findViewById(R.id.textView);
        t2 = findViewById(R.id.textView2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              String strName = e1.getText().toString();
              if(strName.equals(""))
                  e1.setError("enter your name");
              String strAge  = e2.getText().toString();
              int n = Integer.parseInt(strAge);
              t2.setText("Hello "+strName +"!");
          if(n<=120) {
              if (n <= 5)
                  t1.setText("Go to room no 1 and get Drop");
              else if (n > 5 && n <= 10)

                  t1.setText("Go to room no 2 and get syringe");
              else if (n > 10 && n <= 15)

                  t1.setText("Go to room no 3 and get vitamin Tablets");
              else
                  t1.setText("beta ghar jao");
          }else
          {e2.setError("please enter valid Age");
           t1.setText("");
           t2.setText("");}
            }
        });


    }
}
