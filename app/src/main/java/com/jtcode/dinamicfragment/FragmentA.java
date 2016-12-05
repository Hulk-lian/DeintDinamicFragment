package com.jtcode.dinamicfragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;


public class FragmentA extends Fragment {


    private EditText edttext;
    private Button btnSend;
    private SeekBar skvalues;
    private FragmentIterationLisener mCallBack;

    //interfaz para la comunicacion de los diferentes fragments
    public interface  FragmentIterationLisener{
        void onFragmentIterationListener(String text,int value);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            mCallBack=(FragmentIterationLisener)activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+ " must implment FragmentIterationListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        View rootView=inflater.inflate(R.layout.fragment_a,container,false);

        if(rootView!=null){
            edttext=(EditText) rootView.findViewById(R.id.edtTexto);
            btnSend=(Button)rootView.findViewById(R.id.bnt);
            skvalues=(SeekBar)rootView.findViewById(R.id.sskbarra);

            btnSend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mCallBack.onFragmentIterationListener(edttext.getText().toString(),skvalues.getProgress());
                }
            });
        }

        return rootView;
    }
}
