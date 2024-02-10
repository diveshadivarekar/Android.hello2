package com.example.hello2;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ProgressBar downloadProgressBar;
    private TextView tvTitle;
    private Button btnDownload;
    private int progressStatus = 0;
    private Handler handler = new Handler();
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.tvTitle);
        btnDownload = findViewById(R.id.btnDownload);

        tvTitle.setVisibility(View.GONE);

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDownload();
            }
        });
    }

    private void startDownload() {
        // Show downloading dialog
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Downloading...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setProgress(0);
        progressDialog.setMax(100);
        progressDialog.setCancelable(false);
        progressDialog.show();

        new Thread(() -> {
            while (progressStatus < 100) {
                progressStatus += 1;

                handler.post(() -> {
                    progressDialog.setProgress(progressStatus);
                });
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            progressStatus = 0;

            handler.post(() -> progressDialog.dismiss());

            handler.post(() -> {
                downloadProgressBar.setVisibility(View.GONE);
                tvTitle.setVisibility(View.GONE);
            });

            handler.post(() -> btnDownload.setEnabled(true));
        }).start();
    }
}
