package com.ultron.sahilpratap.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner sp;
    Button btn;

  //String course[] = {"Btech","Mtech","BCA","MCA","BBA","MBA"};

    String course[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = findViewById(R.id.spinner);
        btn = findViewById(R.id.button);
        course = getResources().getStringArray(R.array.sppinerArray);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,course);

        sp.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String item = sp.getSelectedItem().toString();
                Toast.makeText(MainActivity.this, "item", Toast.LENGTH_SHORT).show();

            }
        });




    }
}
