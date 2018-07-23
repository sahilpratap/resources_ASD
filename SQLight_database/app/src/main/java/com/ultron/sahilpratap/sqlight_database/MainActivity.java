package com.ultron.sahilpratap.sqlight_database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    MyDatabase db;
    EditText e1,e2,e3,e4;
    Button b1,b2,b3,b4,b5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new MyDatabase(this);
        e1 = findViewById(R.id.editText);
        e2 = findViewById(R.id.editText2);
        e3 = findViewById(R.id.editText3);
        e4 = findViewById(R.id.editText4);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = Integer.parseInt(e1.getText().toString());
                String name = e2.getText().toString();
                String cases = e3.getText().toString();
                String disc = e4.getText().toString();

                CriminalRecord record = new CriminalRecord(id,name,cases,disc);
                db.insertRecord(record);
                Toast.makeText(MainActivity.this,"Data saved! ",Toast.LENGTH_LONG).show();

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String value = e1.getText().toString();
                if(value.equals("")){

                    e1.setError("Please enter Id");

                }else{

                    int id = Integer.parseInt(value);
                    CriminalRecord record = db.getSingleRecord(id);
                    Toast.makeText(MainActivity.this,"Id:- "+record.getId()+"\nNAme:- "+record.getName()+"\nCases"+record.getCases()+"\nDisc:- "+record.getDisc(),Toast.LENGTH_LONG).show();
                }

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<CriminalRecord> list= db.getAllRecord();
                for(CriminalRecord record: list){

                    Toast.makeText(MainActivity.this,"Id:- "+record.getId()+"\nNAme:- "+record.getName()+"\nCases"+record.getCases()+"\nDisc:- "+record.getDisc(),Toast.LENGTH_LONG).show();

                }
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = Integer.parseInt(e1.getText().toString());
                String name = e2.getText().toString();
                String cases = e3.getText().toString();
                String disc = e4.getText().toString();

                CriminalRecord record = new CriminalRecord(id,name,cases,disc);
                db.updateRecord(record);
                Toast.makeText(MainActivity.this,"Record Updated...",Toast.LENGTH_LONG).show();
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String values = e1.getText().toString();
                if(values.equals("")){

                    e1.setError("please enter id");

                }else{

                    int id = Integer.parseInt(values);
                    db.deleteRecord(id);
                    Toast.makeText(MainActivity.this,"Record Deleted...",Toast.LENGTH_LONG).show();

                }

            }
        });
    }
}
