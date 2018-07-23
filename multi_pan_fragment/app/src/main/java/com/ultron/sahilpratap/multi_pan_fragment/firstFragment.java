package com.ultron.sahilpratap.multi_pan_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class firstFragment extends Fragment {


    Button btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_first, container, false);
        btn = v.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               secondFragment secondFragment = (com.ultron.sahilpratap.multi_pan_fragment.secondFragment) getFragmentManager().findFragmentById(R.id.fragment2);
                secondFragment.show("Hello...");
            }
        });
        return v;
    }

}
