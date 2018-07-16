package com.ultron.sahilpratap.secondeventhandlingproject;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //components objects

      EditText e1;
      Button b1;
      TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.editText);
        b1 = findViewById(R.id.button);
        t1 = findViewById(R.id.textView);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name  =  e1.getText().toString();
              //  to convert in integer form
              //  int data = Integer.parseInt(name);

                if(name.equals(""))

                //  Toast.makeText(getApplicationContext(),"please enter your name",Toast.LENGTH_SHORT).show();
                    e1.setError("Please enter your name");
                else

                    t1.setText(""+name);


                //    Toast.makeText(getApplicationContext(),name,Toast.LENGTH_SHORT).show();

                e1.setText("");
            }
        });







    }
}
