package com.example.nazianoorani.inventorymgmt.UI.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.nazianoorani.inventorymgmt.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button addBtn,removeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addBtn = (Button) findViewById(R.id.btn_add_items);
        removeBtn = (Button) findViewById(R.id.btn_remove_item);
        addBtn.setOnClickListener(this);
        removeBtn.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        Log.e("Result Activity", "Working");
        Fragment entryFragment = new EntryFragment();
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanResult != null)
        {
//			Log.e("Scan reslt", scanResult.getContents());
            Bundle bundle = new Bundle();
            bundle.putString("scanResult",scanResult.getContents());
             entryFragment.setArguments(bundle);
        }
        getSupportFragmentManager().beginTransaction().add(R.id.frame_container,entryFragment).commit();

//        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frame_container);
//        fragment.onActivityResult(requestCode, resultCode, intent);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_add_items:

                IntentIntegrator integrator = new IntentIntegrator(this);
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
