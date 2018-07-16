package com.ultron.sahilpratap.picturefromgallery;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URI;

public class MainActivity extends AppCompatActivity {


    Button btn;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction((Intent.ACTION_GET_CONTENT));
                startActivityForResult(Intent.createChooser(intent,"select  picture"),0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode==0 && resultCode ==RESULT_OK && data!=null)
        {
            // Uri use to contain path of file
            Uri filePath = data.getData();

            try {

                //  getCcontentResolver use to get any data from mobile
                InputStream input = getContentResolver().openInputStream(filePath);
                Bitmap bmp = BitmapFactory.decodeStream(input);
                imageView.setImageBitmap(bmp);

            }catch (Exception e){}



        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
