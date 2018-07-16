package com.ultron.sahilpratap.audiocontroler;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.ultron.sahilpratap.audiocontroler.R.*;

public class MainActivity extends AppCompatActivity {

    TextView t1;
    Button b1,b2,b3;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        b1 = findViewById(id.button);
        b2 = findViewById(id.button2);
        b3 = findViewById(id.button3);

        mp = MediaPlayer.create(this, raw.play);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.pause();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();

                mp = MediaPlayer.create(MainActivity.this,R.raw.play);


            }
        });

    }
}
