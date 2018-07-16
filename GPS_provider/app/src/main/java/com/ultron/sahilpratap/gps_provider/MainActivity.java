package com.ultron.sahilpratap.gps_provider;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView t1;
    //This class provides access to the system location services.
    LocationManager lm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         t1 = findViewById(R.id.textView);
     //  COARSE_LOCATION =>current location
     //  FINE => Change location
         if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION},0);
        }


        lm = (LocationManager) getSystemService(LOCATION_SERVICE);

         lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
             @Override
             public void onLocationChanged(Location location) {

                 double latitude = location.getLatitude();
                 double longitude = location.getLongitude();
                 t1.setText("lat:- "+latitude+"\nLon:- "+longitude);
                 Geocoder geocoder = new Geocoder(MainActivity.this);
                 try{

                     List<Address> adr = geocoder.getFromLocation(latitude,longitude,1);
                     String country = adr.get(0).getCountryName();
                     String locality = adr.get(0).getLocality();
                     String pinCode = adr.get(0).getPostalCode();
                     String address= adr.get(0).getAddressLine(0);

                     t1.append("\n\n"+country+","+locality+","+pinCode+","+address);

                 } catch (IOException e) {
                     e.printStackTrace();
                 }

             }

             @Override
             public void onStatusChanged(String provider, int status, Bundle extras) {

             }

             @Override
             public void onProviderEnabled(String provider) {

             }

             @Override
             public void onProviderDisabled(String provider) {

             }
         });


    }

}
