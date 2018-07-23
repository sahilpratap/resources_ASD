package com.ultron.sahilpratap.multi_pan_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class secondFragment extends Fragment {


    TextView t1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_second, container, false);
        t1 = v.findViewById(R.id.textView);

        return inflater.inflate(R.layout.fragment_second, container, false);

    }

    public void show(String msg){

        t1.setText(msg);

    }

}
