package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class test extends AppCompatActivity {

    private static final String tag="first";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(tag,"on create");
    }
    protected void onDestroy()
    {
        super.onDestroy();
        Log.i(tag,"on Destroy");
    }
}
