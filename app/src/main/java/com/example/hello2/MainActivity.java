package com.example.hello2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView statusTextView;

    private BroadcastReceiver powerConnectionReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction() != null) {
                switch (intent.getAction()) {
                    case Intent.ACTION_POWER_CONNECTED:
                        updateStatus("Power connected");
                        break;
                    case Intent.ACTION_POWER_DISCONNECTED:
                        updateStatus("Power disconnected");
                        break;
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusTextView = findViewById(R.id.statusTextView);

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        registerReceiver(powerConnectionReceiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(powerConnectionReceiver);
    }

    private void updateStatus(String status) {
        statusTextView.setText(status);
    }
}
