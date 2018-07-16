package com.ultron.sahilpratap.customotpdailog;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.custom_otp_layout);
                dialog.setCanceledOnTouchOutside(false);
                final  EditText e1 = dialog.findViewById(R.id.editText);
                Button btn2 = dialog.findViewById(R.id.button2);

                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String otp = e1.getText().toString();
                        Toast.makeText(MainActivity.this,""+otp,Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                });


                dialog.show();

            }
        });


    }
}
