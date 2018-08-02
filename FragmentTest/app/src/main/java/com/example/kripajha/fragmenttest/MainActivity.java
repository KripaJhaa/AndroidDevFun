package com.example.kripajha.fragmenttest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentController;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.kripajha.fragmenttest.Models.myDataClasss;

public class MainActivity extends AppCompatActivity {
    FragmentA fa;
    FragmentB fb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fM = getSupportFragmentManager();
        FragmentTransaction fT = fM.beginTransaction();
        fa = new FragmentA();
        fT.add(R.id.frame1, fa);



        fb = new FragmentB();
        fT.add(R.id.frame2, fb);
        fT.commit();
    }

    void getDataA(myDataClasss obj){
        fb.setData(obj);
    }
    void getDataB(myDataClasss obj){
        fa.setData(obj);
    }

}
