package com.example.hello2;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: Hello, World!");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: Hello, World!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: Hello, World!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: Hello, World!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: Hello, World!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: Hello, World!");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: Hello, World!");
    }
}
