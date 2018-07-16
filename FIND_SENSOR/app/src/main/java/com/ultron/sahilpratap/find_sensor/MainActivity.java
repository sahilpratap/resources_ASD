package com.ultron.sahilpratap.find_sensor;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    ArrayList<String> list = new ArrayList<String>();

    SensorManager sm;
    int count=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);

        sm = (SensorManager) getSystemService(SENSOR_SERVICE);


       List<Sensor> sensorList = sm.getSensorList(Sensor.TYPE_ALL);

        for (Sensor sensor:sensorList) {

            list.add((count++)+". "+sensor.getName());


        }







    }
}
