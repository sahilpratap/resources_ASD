package com.ultron.sahilpratap.optionsmenu;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.options_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id)
        {
            case R.id.item1: {
                Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.item2: {

                Toast.makeText(MainActivity.this, "About", Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.item3: {
                Toast.makeText(MainActivity.this, "More", Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.item4: {
                Toast.makeText(MainActivity.this, "Promotions", Toast.LENGTH_LONG).show();
                break;
            }

            case R.id.item5: {
                startActivity(new Intent(Settings.ACTION_SETTINGS));
        //      Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_LONG).show();
                break;
            }
                case R.id.item6:

                Toast.makeText(MainActivity.this,"Contact",Toast.LENGTH_LONG).show();


        }

   //     Toast.makeText(MainActivity.this,"Hello!!",Toast.LENGTH_LONG).show();

        return super.onOptionsItemSelected(item);
    }
}
