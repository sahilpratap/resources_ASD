package com.ultron.sahilpratap.spinneronchecked;

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
    String faculty[];
    String course[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = findViewById(R.id.spinner);
        t1 = findViewById(R.id.textView);
        course = getResources().getStringArray(R.array.course);
        faculty = getResources().getStringArray(R.array.faculty);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,course);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                int n = sp.getSelectedItemPosition();
                t1.setText(faculty[n]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }
}
