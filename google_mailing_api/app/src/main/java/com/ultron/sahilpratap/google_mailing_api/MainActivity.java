package com.ultron.sahilpratap.google_mailing_api;

import android.media.MediaCas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2,e3;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.textView);
        e2 = findViewById(R.id.textView2);
        e3 = findViewById(R.id.textView3);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Thread t = new Thread(){

                  public void run(){

                  String to = e1.getText().toString();
                  String sub = e2.getText().toString();
                  String message = e3.getText().toString();

                  String host = "smtp.gmail.com";
                  String from = "sahilpratap7200@gmail.com";
                  String pass = "sahil173573";

                  try{

                      Properties p = new Properties();

                      Session session = Session.getInstance(p);

                      MimeMessage msg = new MimeMessage(session);

                      InternetAddress toId = new InternetAddress(to);

                      InternetAddress fromId = new InternetAddress(from);

                      msg.setRecipient(Message.RecipientType.TO,toId);

                      msg.setFrom(fromId);
                      msg.setSubject(sub);
                      msg.setText(message);

                     Transport tpt = session.getTransport("smtps");
                     tpt.connect(host,from,pass);
                     tpt.sendMessage(msg,msg.getAllRecipients());
                      Toast.makeText(MainActivity.this,"Mail successfully sent...",Toast.LENGTH_LONG).show();


                  }catch (Exception e){}


                  }

                };

                t.start();

            }
        });



    }
}
