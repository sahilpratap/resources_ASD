package com.ultron.sahilpratap.ragistrationform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner sp;
    EditText e1,e2,e3;
    RadioButton r1,r2;
    CheckBox c1;
    Button b1;
    String course[];
    String faculty[];
    String gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.editText);
        e2 = findViewById(R.id.editText2);
        sp = findViewById(R.id.spinner);
        e3 = findViewById(R.id.editText3);
        r1 = findViewById(R.id.radio);
        r2 = findViewById(R.id.radio2);
        b1 = findViewById(R.id.button);
        b1.setEnabled(false);
        c1 = findViewById(R.id.checkBox);

        course = getResources().getStringArray(R.array.course);
        faculty = getResources().getStringArray(R.array.faculty);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.custom,course);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                int n = sp.getSelectedItemPosition();
                e3.setText(faculty[n]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                b1.setEnabled(true);

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = e1.getText().toString();
                String phoneNo = e2.getText().toString();
                String subject = sp.getSelectedItem().toString();
                String facultyName = e3.getText().toString();
                if(r1.isChecked())
                    gender = r1.getText().toString();
                else if (r2.isChecked())
                    gender = r2.getText().toString();
                else{
                    Toast.makeText(getApplicationContext(),"please select Gender",Toast.LENGTH_LONG).show();
                    b1.setEnabled(false);
                }

                // validation

                if(name.equals(""))
                    e1.setError("Please Enter Name");
                else if(phoneNo.equals("")) {
                    e2.requestFocus();
                    e2.setError("please Enter Phone No");
                }
                else if(facultyName.equals("Faculty Name"))
                    e3.setError("Please select Atleast one Subject");
                else {
                    //    Toast.makeText(getApplicationContext(),""+name+"\n"+phoneNo+"\n"+subject+"\n"+facultyName+"\n"+gender,Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(MainActivity.this, second_activity.class);
                    intent.putExtra("name key", name);
                    intent.putExtra("phone key", phoneNo);
                    intent.putExtra("subject key", subject);
                    intent.putExtra("faculty key", facultyName);
                    intent.putExtra("gender key", gender);
                    startActivity(intent);
                }

            }
        });


    }
}
