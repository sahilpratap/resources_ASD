package com.ultron.sahilpratap.get_inbox;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    List<String> sms = new ArrayList<String>();
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        Uri smsUri = Uri.parse("content://sms/inbox");

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_SMS}, 101);
        }

        Cursor cur = getContentResolver().query(smsUri,null,null,null,null);

       while(cur.moveToNext()) {
            String address = cur.getString(cur.getColumnIndex("address"));
            String body = cur.getString(cur.getColumnIndexOrThrow("body"));
            sms.add("Number: " + address + "\nMessage: " + body);
            count++;
        }

        Toast.makeText(this,""+count,Toast.LENGTH_LONG).show();
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,sms);
        listView.setAdapter(adapter);

        }
}
