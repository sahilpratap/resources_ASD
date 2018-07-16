package com.ultron.sahilpratap.popupmenu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = findViewById(R.id.textView);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(MainActivity.this,t1);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                      int id =   item.getItemId();

                        switch (id){

                            case R.id.item1:
                                t1.setTextColor(Color.RED);
                                break;
                            case R.id.item2:
                                t1.setTextColor(Color.GREEN);
                                break;
                            case R.id.item3:
                                t1.setTextColor(Color.BLUE);

                        }


                        return false;
                    }
                });


                popupMenu.show();

            }
        });


    }
}
