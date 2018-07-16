package com.ultron.sahilpratap.customlistview2;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class customAdapter extends ArrayAdapter {

    ArrayList<Integer> productId;
    ArrayList<String> productName;
    ArrayList<Double> productPrice;
    Activity activity;

    public customAdapter (Activity activity, ArrayList<Integer> productId,ArrayList<String> productName,ArrayList<Double> productPrice)

    {
        super(activity,R.layout.custom_layout,productName);
        this.activity = activity;
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

   public View getView(int position,View convertView,ViewGroup parent) {

       LayoutInflater inflater = activity.getLayoutInflater();

       View v = inflater.inflate(R.layout.custom_layout,null);

       TextView tv = v.findViewById(R.id.textView);
       TextView tv2 = v.findViewById(R.id.textView2);
       TextView tv3 = v.findViewById(R.id.textView3);


       tv.setText(""+productId.get(position));
       tv2.setText(""+productName.get(position));
       tv3.setText(""+productPrice.get(position));

        return  v;
   }

}
