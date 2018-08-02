package com.example.kripajha.fragmenttest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kripajha.fragmenttest.Models.myDataClasss;


public class FragmentA extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("attached", " Fragment A");
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("onCreate","called");
    }
    Button btnA;
    EditText et1A;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_a, container, false);

        et1A=view.findViewById(R.id.et1A);
        btnA= view.findViewById(R.id.btnA);

        Log.d("onCreateView","called");

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDataClasss obj=new myDataClasss(et1A.getText().toString(),1);
                Toast.makeText(getContext(),"Hi from Frag A",Toast.LENGTH_LONG).show();
                ((MainActivity) getActivity()).getDataA(obj);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("onActivityCreated","called");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("onStart","called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("onResume","called");
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.d("onPause","called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("onStop","called");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("onDistroyView","called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy","called");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("onDetatch","called");
    }

    public void setData(myDataClasss obj){
        et1A.setText(obj.name);

    }
}
