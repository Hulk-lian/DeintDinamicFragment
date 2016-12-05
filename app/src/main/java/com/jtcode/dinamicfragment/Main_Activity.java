package com.jtcode.dinamicfragment;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class Main_Activity extends Activity implements FragmentA.FragmentIterationLisener{

    private FragmentA fragmentA;
    private FragmentB fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);
        fragmentA=new FragmentA();
        getFragmentManager().beginTransaction().add(R.id.activity_main_,fragmentA).commit();
    }

    @Override
    public void onFragmentIterationListener(String text, int value) {
        //fragmentB.changeTextProperties(text,value);
        Bundle b= new Bundle();
        b.putString(FragmentB.TEXTKEY,text);
        b.putInt(FragmentB.SIZE_KEY,value);
        fragmentB=FragmentB.newInstance(b);

        //se empieza la transeaccion  del fragmenta a al fragment b
        FragmentTransaction fragmentTransaction= getFragmentManager().beginTransaction().replace(R.id.activity_main_,fragmentB);
        fragmentTransaction.replace(R.id.activity_main_,fragmentB);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
