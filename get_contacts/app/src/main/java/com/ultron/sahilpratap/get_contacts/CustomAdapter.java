package com.ultron.sahilpratap.get_contacts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomAdapter extends ArrayAdapter {

    ArrayList<String> names;
    ArrayList<String> phoneNo;
    Activity activity;
    public CustomAdapter (Activity activity, ArrayList<String> names,ArrayList<String> phoneNo)

    {
        super(activity,R.layout.custom,names);
        this.activity = activity;
        this.names = names;
        this.phoneNo = phoneNo;

    }



    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = activity.getLayoutInflater();

        View v = inflater.inflate(R.layout.custom,null);

        TextView tv = v.findViewById(R.id.textView);
        TextView tv2 = v.findViewById(R.id.textView2);

        tv.setText(""+names.get(position));
        tv2.setText(""+phoneNo.get(position));

        return  v;
    }

}
