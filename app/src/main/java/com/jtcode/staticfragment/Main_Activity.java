package com.jtcode.staticfragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;

public class Main_Activity extends Activity implements FragmentA.FragmentIterationLisener{

    private FragmentB fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);
        fragmentB=(FragmentB)getFragmentManager().findFragmentById(R.id.fragB);
    }

    @Override
    public void onFragmentIterationListener(String text, int value) {
        fragmentB.changeTextProperties(text,value);
    }
}
