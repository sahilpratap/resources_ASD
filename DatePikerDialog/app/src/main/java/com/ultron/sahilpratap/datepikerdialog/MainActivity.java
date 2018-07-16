package com.ultron.sahilpratap.datepikerdialog;

import android.app.DatePickerDialog;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    int yr;
    int mon;
    int day;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.editText);
        Calendar calendar = Calendar.getInstance();
        yr = calendar.get(Calendar.YEAR);
        mon = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                   new DatePickerDialog(MainActivity.this,date, yr, mon, day).show();

        /*      we want use date piker dialog in project so we have to call five parameters type of constructer pf date piker class
                parameters are 1.onDateContest
                2.onDateSetLIstener
                3.intYear
                4.intMonth
                5.intDayOfMonth
        */

            }
        });

    }

       DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
           @Override
           public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

               yr = year;
               mon = month;
               day = dayOfMonth;

               e1.setText(dayOfMonth+"/"+(month+1)+"/"+year);


           }
       };

}
