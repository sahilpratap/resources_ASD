package com.ultron.sahilpratap.useofservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
    return null;
    }

    @Override
    public void onCreate() {

        Toast.makeText(this,"service Created",Toast.LENGTH_LONG).show();

        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {

        Toast.makeText(this,"service Started",Toast.LENGTH_LONG).show();

        super.onStart(intent, startId);
    }

    @Override
    public void onDestroy() {

        Toast.makeText(this,"service Destroyed",Toast.LENGTH_LONG).show();

        super.onDestroy();
    }
}
