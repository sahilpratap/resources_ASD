package com.ultron.sahilpratap.customlistview2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Integer> productId = new ArrayList<Integer>();
    ArrayList<String> productName = new ArrayList<String>();
    ArrayList<Double> productPrice = new ArrayList<Double>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);


        //product id
        productId.add(101);
        productId.add(102);
        productId.add(103);

        //product name
        productName.add("Dantkranti");
        productName.add("Keshkanti");
        productName.add("kranti");

        //product price
        productPrice.add(20.0);
        productPrice.add(30.0);
        productPrice.add(40.0);


        customAdapter adapter = new customAdapter(this,productId,productName,productPrice);
        listView.setAdapter(adapter);

    }
}
