package com.ultron.sahilpratap.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView web;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        web = findViewById(R.id.myWeb);

        web.getSettings().setJavaScriptEnabled(true);
        web.setWebViewClient(new WebViewClient());
        web.loadUrl("http://www.google.com");
        //web.goForward();
        //web.goBack();

    }

    @Override
    public void onBackPressed() {

        web.getOriginalUrl();



        super.onBackPressed();
    }
}
