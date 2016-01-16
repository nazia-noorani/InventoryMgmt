package com.example.nazianoorani.inventorymgmt.UI.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nazianoorani.inventorymgmt.Adapter.CardAdapter;
import com.example.nazianoorani.inventorymgmt.Utils.DividerItemDecoration;
import com.example.nazianoorani.inventorymgmt.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by nazianoorani on 22/12/15.
 **/
public class Tab1 extends Fragment implements View.OnClickListener {
//    RecyclerView recyclerView;
//    CardAdapter adapter;
    FloatingActionButton fab;
    RelativeLayout addItemLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_1,container,false);
//        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        addItemLayout = (RelativeLayout) view.findViewById(R.id.layout_add_item);
        Bundle bundle = getArguments();
        if(null != bundle){
         handelScannedResult(bundle);
        }
        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(this);

        return view;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        Log.e("Result Scanned", scanResult.getContents() + "  " + scanResult.toString());


        if (scanResult != null) {

            Log.e("Result Scanned",scanResult.getContents()+"  "+ scanResult.toString());
        }

        }

    public void handelScannedResult(Bundle bundle){

        addItemLayout.setVisibility(View.VISIBLE);

        }


@Override
public void onClick(View v)
{
    switch (v.getId())
    {
        case R.id.fab:

            IntentIntegrator integrator = new IntentIntegrator(getActivity());
            integrator.setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES);
            integrator.setPrompt("Scan a barcode");
            integrator.setCameraId(0);  // Use a specific camera of the device
            integrator.setBeepEnabled(false);
            integrator.setBarcodeImageEnabled(true);
            integrator.initiateScan();

            break;


    }

}
}




