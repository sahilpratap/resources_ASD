package com.ultron.sahilpratap.customlistview;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class customAdapter extends ArrayAdapter<String> {

    Integer images[];
    Activity activity;
    String text[];


    public customAdapter(Activity activity, String text[], Integer images[]){


        super(activity,R.layout.custom_layout,text);
        this.activity=activity;
        this.images=images;
        this.text=text;

    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {

        LayoutInflater inflater = activity.getLayoutInflater();

        View v = inflater.inflate(R.layout.custom_layout,null);

        TextView tv = v.findViewById(R.id.textView);
        ImageView iv = v.findViewById(R.id.imageView);
        tv.setText(text[position]);
        iv.setImageResource(images[position]);
        return v;

    }
}