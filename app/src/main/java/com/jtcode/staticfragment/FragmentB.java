package com.jtcode.staticfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB extends Fragment {

    private TextView txv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View rootView=inflater.inflate(R.layout.fragment_b,container,false);

        if(rootView!=null){
            txv=(TextView)rootView.findViewById(R.id.txvTextorecibido);
        }
        return rootView;
    }

    /**
     * @param text texto que se quiere mostrar
     * @param fonSize tamaño del texto
     */
    public void changeTextProperties(String text,int fonSize){
        txv.setText(text);
        txv.setTextSize(fonSize);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("texto",txv.getText().toString());
        outState.putFloat("tam",txv.getTextSize());
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState!=null){
            txv.setText(savedInstanceState.getString("texto"));
            txv.setTextSize(TypedValue.COMPLEX_UNIT_PX,savedInstanceState.getFloat("tam"));
        }
    }
}
