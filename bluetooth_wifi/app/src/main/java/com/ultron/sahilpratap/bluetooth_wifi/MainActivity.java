package com.ultron.sahilpratap.bluetooth_wifi;

import android.bluetooth.BluetoothAdapter;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton tb;
    Switch aSwitch;

    BluetoothAdapter bluetoothAdapter;
    WifiManager wifi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tb = findViewById(R.id.toggleButton);
        aSwitch= findViewById(R.id.switch1);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        wifi = (WifiManager) this.getApplicationContext().getSystemService(WIFI_SERVICE);

        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked==true){

                    wifi.setWifiEnabled(true);
                }else {
                    wifi.setWifiEnabled(false);
                }

            }
        });

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked==true){

                    bluetoothAdapter.enable();
                }
                else{

                    bluetoothAdapter.enable();
                }



            }
        });




    }
}
