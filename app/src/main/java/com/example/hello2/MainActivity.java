// MainActivity.java
package com.example.hello2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText numberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberEditText = findViewById(R.id.numberEditText);
    }

    public void calculateFactorial(View view) {
        String numberStr = numberEditText.getText().toString();

        if (!numberStr.isEmpty()) {
            int number = Integer.parseInt(numberStr);

            Intent intent = new Intent(this, ResultActivity.class);

            intent.putExtra("number", number);

            startActivity(intent);
        }
    }
}
