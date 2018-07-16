package com.ultron.sahilpratap.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView list;

    Integer images[] = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f};

    String text[] =  {"Alpha","Beta","Cupcake","Donot","Eclears","Foryo"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.listView);

        customAdapter adapter = new customAdapter(this,text,images);
        list.setAdapter(adapter);



    }
}
