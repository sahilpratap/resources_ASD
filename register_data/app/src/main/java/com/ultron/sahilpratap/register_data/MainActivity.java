package com.ultron.sahilpratap.register_data;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2,e3;
    Button btn1,btn2;
    String url ="https://first-android.000webhostapp.com/setdata.php";
    String userName,email,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.textView);
        e2 = findViewById(R.id.textView2);
        e3 = findViewById(R.id.textView3);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 userName = e1.getText().toString();
                 email = e2.getText().toString();
                 pass = e3.getText().toString();

                 new Dataprocess().execute();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });

    }

    class Dataprocess extends AsyncTask<String,String,String>{

        ProgressDialog pd;

        @Override
        protected void onPreExecute() {

            pd = new ProgressDialog(MainActivity.this);
            pd.setMessage("Uploading...");
            pd.show();

            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {


                try {

                ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("userName", userName));
                params.add(new BasicNameValuePair("email", email));
                params.add(new BasicNameValuePair("password", pass));

                DefaultHttpClient httpClient = new DefaultHttpClient();

                HttpPost httpPost = new HttpPost(url);

                httpPost.setEntity(new UrlEncodedFormEntity(params));
                httpClient.execute(httpPost);

                }catch (Exception e){}

                return null;
        }

        @Override
        protected void onPostExecute(String s) {

            pd.dismiss();
            e1.setText("");
            e2.setText("");
            e3.setText("");
            Toast.makeText(MainActivity.this,"Data Saved..",Toast.LENGTH_LONG).show();
            super.onPostExecute(s);
        }

    }
}
