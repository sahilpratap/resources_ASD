package com.ultron.sahilpratap.callsms;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> description = new ArrayList<String>();
    ArrayList<Integer> images = new ArrayList<Integer>();
    CustomAdapter adapter;
    public static Bitmap bmp;
    String nm[];
    String desc[];
    Integer img[] ={};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        nm = getResources().getStringArray(R.array.names);
        desc = getResources().getStringArray(R.array.description);

        for(int i=0;i<img.length;i++){

            names.add(nm[i]);
            description.add(desc[i]);
            images.add(img[i]);
        }


        adapter = new CustomAdapter(MainActivity.this,names,description,images);

        listView.setAdapter(adapter);

        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        menu.add("Edit Name");
        menu.add("Change Profession");
        menu.add("Change Image");
        menu.add("Delete");

        super.onCreateContextMenu(menu, v, menuInfo);
    }


}

