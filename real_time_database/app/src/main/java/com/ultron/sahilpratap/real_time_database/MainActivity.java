package com.ultron.sahilpratap.real_time_database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {


    EditText t1,t2;
    Button btn1,btn2;
     FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = findViewById(R.id.editText);
        t2 = findViewById(R.id.editText2);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button_2);


        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String teamName = t1.getText().toString();
                String teamScore = t2.getText().toString();

                Score score = new Score();
                score.setTeamNAme(teamName);
                score.setTeamScore(teamScore);
                reference.setValue(score);
                t1.setText("");
                t2.setText("");

                Toast.makeText(MainActivity.this,"Record updated",Toast.LENGTH_LONG).show();



            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                      Score score =  dataSnapshot.getValue(Score.class);

                        String l = score.getTeamNAme();
                        String a = score.getTeamScore();
                        Toast.makeText(MainActivity.this,"Team:- "+l+"\nScore:- "+a,Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });

    }
}
