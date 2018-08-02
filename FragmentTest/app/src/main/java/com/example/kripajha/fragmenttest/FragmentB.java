package com.example.kripajha.fragmenttest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kripajha.fragmenttest.Models.myDataClasss;

public class FragmentB extends Fragment {

    Button btnB;
    EditText et1B;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b,container,false);

        et1B=view.findViewById(R.id.et1B);


        btnB=view.findViewById(R.id.btnB);
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDataClasss obj=new myDataClasss(et1B.getText().toString(),1);
                //Toast.makeText(getContext(),"Hi from Frag B",Toast.LENGTH_LONG).show();
                ((MainActivity) getActivity()).getDataB(obj);
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("attached", " Fragment B");
    }

    public void setData(myDataClasss obj){
        et1B.setText(obj.name);
    }

}
