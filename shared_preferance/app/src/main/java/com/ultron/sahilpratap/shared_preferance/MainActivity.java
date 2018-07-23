package com.ultron.sahilpratap.shared_preferance;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    Button b1,b2,b3;

    SharedPreferences pref;  // contens .xml shred preferances file
    SharedPreferences.Editor editor; // contens file edit referance

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 =findViewById(R.id.editText);
        e2 =findViewById(R.id.editText2);

        b1 =findViewById(R.id.button);
        b2 =findViewById(R.id.button2);
        b3 =findViewById(R.id.button3);

        pref = getSharedPreferences("jadu", Context.MODE_PRIVATE);
        editor = pref.edit();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = e1.getText().toString();
                String phone = e2.getText().toString();

                editor.putString("name_key",name);
                editor.putString("phoneNo_key",phone);
                editor.commit();
                Toast.makeText(MainActivity.this,"Data saved",Toast.LENGTH_LONG).show();

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String name = pref.getString("name_key","No Data");
               String phone = pref.getString("phoneNo_key","No Data");
               Toast.makeText(MainActivity.this,""+name+"\n"+phone,Toast.LENGTH_LONG).show();

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

          //      editor.clear();
          //      editor.commit();

                editor.remove("name_key");
                editor.commit();

            }
        });

    }
}
