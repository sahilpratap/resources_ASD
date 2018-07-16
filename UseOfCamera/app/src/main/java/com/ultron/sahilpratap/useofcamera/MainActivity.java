package com.ultron.sahilpratap.useofcamera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.sax.StartElementListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    ImageButton i1,i2;
    ImageView image;
    Bitmap bmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        i1 = findViewById(R.id.imageButton);
        i2 = findViewById(R.id.imageButton2);
        image = findViewById(R.id.imageView);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent((MediaStore.ACTION_IMAGE_CAPTURE));
                startActivityForResult(intent,420);


            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    getApplicationContext().setWallpaper(bmp);
                }catch (Exception e){}
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // result code 0 or 1
        // camera internally uses putextra function

        if(requestCode==420 && resultCode==RESULT_OK && data!=null) {
            Bundle bundle = data.getExtras();
            bmp = (Bitmap) bundle.get("data");

            image.setImageBitmap(bmp);
        }else
        {
            Toast.makeText(MainActivity.this,"Try again",Toast.LENGTH_LONG).show();
        }


        super.onActivityResult(requestCode, resultCode, data);
    }
}
