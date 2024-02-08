// src/com.example.yourappname/MainActivity.java
package com.example.hello2;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton4 = findViewById(R.id.radioButton4);

        radioGroup = findViewById(R.id.radioGroup);
    }

    public void onShowSelectionClick(View view) {
        StringBuilder selectedRadioButton = new StringBuilder("Selected Radio Button: ");

        if (radioButton1.isChecked()) {
            selectedRadioButton.append(radioButton1.getText().toString());
        } else if (radioButton2.isChecked()) {
            selectedRadioButton.append(radioButton2.getText().toString());
        } else if (radioButton3.isChecked()) {
            selectedRadioButton.append(radioButton3.getText().toString());
        } else if (radioButton4.isChecked()) {
            selectedRadioButton.append(radioButton4.getText().toString());
        } else {
            selectedRadioButton.append("None");
        }

        Toast.makeText(this, selectedRadioButton.toString(), Toast.LENGTH_SHORT).show();
    }
}
