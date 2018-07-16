package com.ultron.sahilpratap.register_data;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    ListView listView;

    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;
    String url;
    String jsonData;
    // Define tags

    public static  final String TAG_RESULT = "result";
    public static  final String TAG_ID = "id";
    public static  final String TAG_USERNAME = "userName";
    public static  final String TAG_EMAIL = "email";
    public static  final String TAG_PASSWORD = "password";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = findViewById(R.id.listView);

        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter);
        url = "https://first-android.000webhostapp.com/getdata.php";
        new DataProcess().execute();

    }

    // inner class

    class DataProcess extends AsyncTask<String,String,String>{

        ProgressDialog pd;


        @Override
        protected void onPreExecute() {

            pd = new ProgressDialog(Main2Activity.this);
            pd.setMessage("Dowloading...");
            pd.show();

            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Content-type","application/json");

            InputStream inputStream = null;
            String result = null;

            try{

                HttpResponse httpResponse = httpClient.execute(httpPost);
                HttpEntity entity = httpResponse.getEntity();

                inputStream = entity.getContent();

                //json is UTF-8 by default

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(inputStream,"UTF-8"),8);
                StringBuilder sb = new StringBuilder();
                String line  = null;

                while((line = reader.readLine()) != null){

                    sb.append(line+"\n");
                }
                result = sb.toString();
            }catch (Exception e){


            } finally {

                try{
                    if(inputStream != null)
                        inputStream.close();

                }catch (Exception e){}
            }
            return result;
        }


        @Override
        protected void onPostExecute(String s) {

            jsonData = s;
            showRecord();
            pd.dismiss();
            super.onPostExecute(s);
        }
    }

    public void showRecord() {

        try{
        JSONObject jsonObject = new JSONObject(jsonData);
        JSONArray jsonArray = jsonObject.getJSONArray(TAG_RESULT);

        for(int i=0;i<jsonArray.length();i++) {

            JSONObject obj = jsonArray.getJSONObject(i);
            String id = obj.getString(TAG_ID);
            String userName = obj.getString(TAG_USERNAME);
            String email = obj.getString(TAG_EMAIL);
            String password = obj.getString(TAG_PASSWORD);
            arrayList.add("Id:- " + id + "\nuserName:- " + userName + "\nEmail:- " + email + "\nPassword: " + password);
            adapter.notifyDataSetChanged();

        }
        }catch (Exception e){}
    }
}
