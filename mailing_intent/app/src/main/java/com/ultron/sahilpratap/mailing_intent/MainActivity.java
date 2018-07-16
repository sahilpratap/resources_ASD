package com.ultron.sahilpratap.mailing_intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1= findViewById(R.id.editText);
        e2= findViewById(R.id.editText2);
        b1= findViewById(R.id.button);


        b1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                String sub = e1.getText().toString();
                String text = e2.getText().toString();
                postQuery(sub,text);

                return false;
            }
        });


    }
    public void postQuery(String subject,String query){


        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));

        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"sahilbundela230@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,subject);
        intent.setType("*/*");
        startActivity(Intent.createChooser(intent,"Email"));
    }
}
