package com.ultron.sahilpratap.firstintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.editText);
        e2 = findViewById(R.id.editText2);
        b1 = findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = e1.getText().toString();
                String address = e2.getText().toString();


                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("name key",name);
                intent.putExtra("address key",address);
                startActivity(intent);
            }
        });
    }
}
