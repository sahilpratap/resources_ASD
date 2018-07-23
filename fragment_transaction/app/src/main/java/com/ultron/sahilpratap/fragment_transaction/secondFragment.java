package com.ultron.sahilpratap.fragment_transaction;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class secondFragment extends Fragment {

    TextView t1;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_second, container, false);
        t1 = v.findViewById(R.id.textView);

        Bundle bundle = getArguments();
        t1.setText(bundle.getString("name_key")+"\n"+bundle.getString("phone_key"));
        return v;
    }

}
