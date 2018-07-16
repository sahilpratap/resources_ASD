package com.ultron.sahilpratap.metrofare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner sp1,sp2;
    Button btn;
    TextView e1;
    String station[];
    String distance[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp1 = findViewById(R.id.spinner);
        sp2 = findViewById(R.id.spinner2);
        btn = findViewById(R.id.button);
        e1 = findViewById(R.id.textView);
        station = getResources().getStringArray(R.array.stations);
        distance = getResources().getStringArray(R.array.dist);

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,station);

        sp1.setAdapter(adapter);
        sp2.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1 = sp1.getSelectedItem().toString();
                String s2 = sp2.getSelectedItem().toString();
                int n1 = sp1.getSelectedItemPosition();
                int n2 = sp2.getSelectedItemPosition();
                double d1 =  Double.parseDouble(distance[n1]);
                double d2 = Double.parseDouble(distance[n2]);
                double result = Math.abs(d1-d2);
         //     Toast.makeText(getApplicationContext(),""+result,Toast.LENGTH_SHORT).show();
                if(n1==0 || n2==0)
                    Toast.makeText(getApplicationContext(),"Please enter different Destination",Toast.LENGTH_LONG).show();
               else if (result==0)
                    Toast.makeText(getApplicationContext(),"Please enter different Destination",Toast.LENGTH_LONG).show();
                else if(result <2)
                    e1.setText("Price is: 10");
                else if(result>=2 && result<5)
                    e1.setText("Price is: 20");
                else if (result>=5 && result<12)
                    e1.setText("price is: 30");
                else if(result>=12 && result<21)
                    e1.setText("Price is: 40");
                else
                    e1.setText("Price is: 50");

            }
        });



    }
}
