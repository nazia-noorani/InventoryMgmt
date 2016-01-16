package com.example.nazianoorani.inventorymgmt.UI.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;


import android.view.Menu;
import android.view.MenuItem;

import com.example.nazianoorani.inventorymgmt.Adapter.ViewPagerAdapter;
import com.example.nazianoorani.inventorymgmt.R;
import com.example.nazianoorani.inventorymgmt.Utils.SlidingTabLayout;

public class MainActivity extends AppCompatActivity{

    // Declaring Your View and Variables
//    Toolbar toolbar;
    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"INCOMING","OUTGOING"};
    int Numboftabs =2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Creating The Toolbar and setting it as the Toolbar for the activity

//        toolbar = (Toolbar) findViewById(R.id.tool_bar);
//        setSupportActionBar(toolbar);toolbar
        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        adapter =  new ViewPagerAdapter(getSupportFragmentManager(),Titles,Numboftabs);

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width


        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);



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


        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.pager);
        fragment.onActivityResult(requestCode, resultCode, intent);


       IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanResult != null)
		{
			Log.e("Scan reslt", scanResult.getContents());
		}
            // handle scan result
/*

/*        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanResult != null) {
            // handle scan result


//            String s = "http://www.google.com/search?q=";
//            s += scanResult.getContents();


            Bundle bundle=new Bundle();
            bundle.putString("scanResult", scanResult.getContents());
            Tab1 tab1 = new Tab1();
            tab1.setArguments(bundle); // This line is needed...
            tab1.handelScannedResult(bundle);
//            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//            transaction.replace(R.id.pager, tab1);
//            transaction.addToBackStack(null);
//            transaction.commit();
//            Intent myIntent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(s));
//            startActivity(myIntent1);

        }*/
        // else continue with any other code you need in the method
        //...
    }
}
