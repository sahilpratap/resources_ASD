package com.ultron.sahilpratap.staticlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String places[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        places = getResources().getStringArray(R.array.items);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,places);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position==0)
                {
                    Toast.makeText(getApplicationContext(),"Welcom to Goa",Toast.LENGTH_LONG).show();
                }
                else if(position==1)
                {
                    Toast.makeText(getApplicationContext(),"Welcom to Nainital",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
