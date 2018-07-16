package com.ultron.sahilpratap.get_contacts;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> phoneNo = new ArrayList<String>();
    ListView listView;
    int count=0;
    int itemId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);

        CustomAdapter adapter = new CustomAdapter(this,names,phoneNo);

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_CONTACTS)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CONTACTS,Manifest.permission.WRITE_CONTACTS},101);
        }


        Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, null);
        while (phones.moveToNext())
        {
            String name=phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            names.add(name);
            phoneNo.add(phoneNumber);
            count++;

        }
        Toast.makeText(getApplicationContext(),""+count, Toast.LENGTH_LONG).show();
        phones.close();
        listView.setAdapter(adapter);
        registerForContextMenu(listView);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        menu.add("Call");
        menu.add("Messaage");

        super.onCreateContextMenu(menu, v, menuInfo);
    }


    @SuppressLint("MissingPermission")
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        int id = item.getItemId();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        itemId = info.position;
        String tittle = item.getTitle().toString();
        final Dialog dialog = new Dialog(MainActivity.this);

        switch (tittle) {

            case "Call":


                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 101);

                }

                Intent intent = new Intent(Intent.ACTION_CALL);
                String number = phoneNo.get(itemId);
                intent.setData(Uri.parse("tel:" + number));
                // tel is a key
                startActivity(intent);

            case "Message":

                dialog.setContentView(R.layout.custom_sms);
                dialog.setCanceledOnTouchOutside(false);
                final EditText e1 = dialog.findViewById(R.id.editText3);
                Button btn = dialog.findViewById(R.id.button2);
                dialog.show();

                if(ActivityCompat.checkSelfPermission(MainActivity.this,Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS}, 101);

                }

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String t = e1.getText().toString();
                        String number = phoneNo.get(itemId).toString();

                        SmsManager sms = SmsManager.getDefault();

                        sms.sendTextMessage(number, null, t, null, null);
                        Toast.makeText(MainActivity.this, "sms Sent..", Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                });

        }
        return super.onContextItemSelected(item);
    }
    }
