package com.ultron.sahilpratap.taghost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout l1;
    CheckBox c1,c2,c3,c4;
    TextView t;

    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabHost = findViewById(R.id.mytab);
        l1 = findViewById(R.id.tab1);
        c1 = findViewById(R.id.checkBox);
        c2 = findViewById(R.id.checkBox2);
        c3 = findViewById(R.id.checkBox3);
        c4 = findViewById(R.id.checkBox4);
        t = findViewById(R.id.newtext);
        tabHost.setup();

        TabHost.TabSpec tabSpec   =   tabHost.newTabSpec("");

        tabSpec.setIndicator("Test");
        tabSpec.setContent(R.id.tab1);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("");
        tabSpec.setIndicator("Result");
        tabSpec.setContent(R.id.tab2);
        tabHost.addTab(tabSpec);

        String result1="",result2="",result3="",result4="";
        if(c1.isChecked())
             result1 = c1.getText().toString();
        if(c2.isChecked())
            result2 = c2.getText().toString();
        if(c3.isChecked())
            result1 = c3.getText().toString();
        if(c4.isChecked())
            result1 = c4.getText().toString();


        t.setText(""+result1+"\n"+result2+"\n"+result3+"\n"+result4);
/*
        tabSpec = tabHost.newTabSpec("");
        tabSpec.setIndicator("APP");
        tabSpec.setContent(R.id.tab3);
        tabHost.addTab(tabSpec);

*/

    }
}
