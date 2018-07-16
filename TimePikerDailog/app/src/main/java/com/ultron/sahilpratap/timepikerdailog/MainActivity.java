package com.ultron.sahilpratap.timepikerdailog;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    int hr;
    int min;
    int sec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.editText);

        e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();
                hr = calendar.get(Calendar.HOUR);
                min = calendar.get(Calendar.MINUTE);
                sec = calendar.get(Calendar.SECOND);

                new TimePickerDialog(MainActivity.this,time,hr,min,false).show();

            }
        });

    }

    TimePickerDialog.OnTimeSetListener time = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            e1.setText(""+hourOfDay+" : "+minute);

        }
    };



}
