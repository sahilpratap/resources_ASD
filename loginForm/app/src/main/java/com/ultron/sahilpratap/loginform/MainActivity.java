package com.ultron.sahilpratap.loginform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5,e6;
    RadioButton r1,r2;
    CheckBox c1;
    Button btn;
    RadioGroup rg;
    String result;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String userNamePattern = "^[a-z0-9_-]{3,15}$";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        e1 = findViewById(R.id.editText);
        e2 = findViewById(R.id.editText1);
        e3 = findViewById(R.id.editText2);
        e4 = findViewById(R.id.editText4);
        e5 = findViewById(R.id.editText5);
        e6 = findViewById(R.id.editText7);
        r1 = findViewById(R.id.radioButton);
        r2 = findViewById(R.id.radioButton2);
        c1 = findViewById(R.id.checkBox);
        btn = findViewById(R.id.button);
        btn.setEnabled(false);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                String s4 = e4.getText().toString();
                String s5 = e5.getText().toString();
                String s6 = e6.getText().toString();
                if(r1.isChecked())
                    result = r1.getText().toString();
                else if(r2.isChecked())
                    result = r2.getText().toString();
                else
                    result = "";
        // validation
                if(s1.equals(""))
                    e1.setError("please enter your name");
                else if(s2.equals("") || !s2.matches(userNamePattern) )
                    e2.setError("Please Enter your User Name");
                else  if(s3.equals("") || !s3.matches(emailPattern))
                    e3.setError("Please Enter valid email address Email Id");
                else  if(s4.equals(""))
                    e4.setError("Please Enter your Class");
                else  if(s5.equals(""))
                    e5.setError("Please Enter your Section");
                else if(s6.equals(""))
                    e6.setError("Please Enter your Password");
                else  if(!r1.isChecked() && !r2.isChecked())
                    r2.setError("Please select one option");
                else
                    Toast.makeText(getApplicationContext(),"name: "+s1+"\nuserName: "+s2+"\nEmail id: "+s3+"\nclass: "+s4+"\nsection: "+s5+"\nGender: "+result,Toast.LENGTH_LONG).show();
            }
        });

        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                btn.setEnabled(true);

            }
        });

    }
}
