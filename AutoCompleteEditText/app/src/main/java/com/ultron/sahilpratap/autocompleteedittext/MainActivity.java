package com.ultron.sahilpratap.autocompleteedittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {


    AutoCompleteTextView a;
    String values[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = findViewById(R.id.autoCompleteTextView);

        values = getResources().getStringArray(R.array.data);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,values);

        a.setAdapter(adapter);
        a.setThreshold(1);



    }
}
