package com.jtcode.dinamicfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class FragmentC extends Fragment {

    private WebView webView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View rootView=inflater.inflate(R.layout.fragment_c,container,false);

        if(rootView!=null){
            webView=(WebView)rootView.findViewById(R.id.wvi_fragment_c);
        }
        webView.loadData(getResources().getString(R.string.cadena_htmlalter),"text/html", Xml.Encoding.UTF_8.toString());
        return rootView;
    }
}
