package com.ultron.sahilpratap.contexmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView list;


    String arr[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arr = getResources().getStringArray(R.array.names);
        list = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,arr);
        list.setAdapter(adapter);

        registerForContextMenu(list);

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        menu.add("Delete");
        menu.add("Rename");
        menu.add("Forward");
        menu.add("Reply");

        super.onCreateContextMenu(menu, v, menuInfo);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {

        String tittle = item.getTitle().toString();


        switch (tittle){

            case "Delete":

                Toast.makeText(MainActivity.this,"item Deleted",Toast.LENGTH_LONG).show();
                break;
            case "Rename":

                Toast.makeText(MainActivity.this,"item Deleted",Toast.LENGTH_LONG).show();
                break;

            case "Forward":

                Toast.makeText(MainActivity.this,"item Deleted",Toast.LENGTH_LONG).show();
                break;
            case "Reply":

                Toast.makeText(MainActivity.this,"item Deleted",Toast.LENGTH_LONG).show();

        }



        return super.onContextItemSelected(item);
    }
}
