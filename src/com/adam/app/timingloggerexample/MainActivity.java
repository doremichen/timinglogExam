/**
 * ===========================================================================
 * Copyright Adam Sample code
 * All Rights Reserved
 * ===========================================================================
 * 
 * File Name: MainActivity.java
 * Brief: This is used for TimingLogger example. Please type the command 
 *        "adb shell setprop log.tag.<MYTAG> VERBOSE" before running Timing log function.
 * 
 * Author: AdamChen
 * Create Date: 2018/2/21
 */
package com.adam.app.timingloggerexample;

import android.app.Activity;
import android.os.Bundle;
import android.util.TimingLogger;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();
    
    /**
     * 
     * <h1>onCreate</h1>
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TimingLogger timeLog = new TimingLogger(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        timeLog.addSplit("Work super onCreate");
        setContentView(R.layout.activity_main);
        timeLog.addSplit("Work setContentView");
        // dump log
        timeLog.dumpToLog();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
