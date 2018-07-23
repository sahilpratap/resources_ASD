package com.ultron.sahilpratap.filehandling;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    Button b1,b2;
    public  static  final String FILE = "jadu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.editText);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String data = e1.getText().toString();
                try{

                    FileOutputStream fout = openFileOutput(FILE, Context.MODE_APPEND);
                    fout.write(data.getBytes());
                    Toast.makeText(MainActivity.this,"data saved",Toast.LENGTH_LONG).show();

                }catch (Exception e){}
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                try {

                    FileInputStream fin = openFileInput(FILE);
                    int x=0;
                    String data="";

                    while((x=fin.read()) != (-1)) {

                        data = data+Character.toString((char) x);

                    }

                    Toast.makeText(MainActivity.this,""+data,Toast.LENGTH_LONG).show();

                }catch (Exception e){}

            }
        });
    }
}
