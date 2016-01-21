package com.example.nazianoorani.inventorymgmt.UI.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nazianoorani.inventorymgmt.R;

/**
 * Created by nazianoorani on 17/01/16.
 */
public class EntryFragment extends Fragment {
    @Nullable
    TextView textViewTitle;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        View  view = inflater.inflate(R.layout.fragment_entry,container,false);
        textViewTitle = (TextView) view.findViewById(R.id.textView_title);
        if(bundle != null){
        String str = bundle.getString("scanResult");
        textViewTitle.setText(str);
        }

        return view;


    }
}
