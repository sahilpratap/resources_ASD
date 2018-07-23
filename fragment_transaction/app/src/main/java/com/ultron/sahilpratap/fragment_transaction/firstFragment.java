package com.ultron.sahilpratap.fragment_transaction;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class firstFragment extends Fragment {

    EditText e1,e2;

    Button btn;


    public firstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_first, container, false);
        e1 = v.findViewById(R.id.editText);
        e2 = v.findViewById(R.id.editText2);
        btn = v.findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = e1.getText().toString();
                String phone = e2.getText().toString();
                secondFragment fragment = new secondFragment();
                Bundle bundle = new Bundle();
                bundle.putString("name_key",name);
                bundle.putString("name_phone",phone);

                fragment.setArguments(bundle);
                FragmentManager fm = getFragmentManager();

                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.mainActivity,fragment);
                ft.addToBackStack("First Fragment store to back stack");
                ft.commit();


            }
        });

        return v;
    }

}
