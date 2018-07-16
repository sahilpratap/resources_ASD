package com.ultron.sahilpratap.videoplayer;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {



    VideoView vd ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vd =findViewById(R.id.videoView);

        vd.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video));
        vd.setMediaController(new MediaController(this));
        vd.start();

    }
}
