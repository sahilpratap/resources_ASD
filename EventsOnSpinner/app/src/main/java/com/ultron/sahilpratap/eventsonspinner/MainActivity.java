package com.ultron.sahilpratap.eventsonspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner sp;
    TextView t1;
    String places[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = findViewById(R.id.spinner2);
        t1 = findViewById(R.id.textView2);

        places = getResources().getStringArray(R.array.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,places);

        sp.setAdapter(adapter);


        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position==1)
                    t1.setText((places[position]));
                else if(position ==2)
                    t1.setText(places[position]);
             }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





    }
}
