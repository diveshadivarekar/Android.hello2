// ResultActivity.java
package com.example.hello2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        int number = getIntent().getIntExtra("number", 0);

        long factorial = calculateFactorial(number);

        TextView resultTextView = findViewById(R.id.resultTextView);
        resultTextView.setText("Factorial of " + number + " is: " + factorial);
    }

    private long calculateFactorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }
}
