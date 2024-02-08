package com.example.hello2;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
    }

    public void onShowSelectionClick(View view) {
        StringBuilder selectedCheckboxes = new StringBuilder("Selected Checkboxes: ");

        if (checkBox1.isChecked()) {
            selectedCheckboxes.append("Checkbox 1, ");
        }

        if (checkBox2.isChecked()) {
            selectedCheckboxes.append("Checkbox 2, ");
        }

        if (checkBox3.isChecked()) {
            selectedCheckboxes.append("Checkbox 3, ");
        }

        if (checkBox4.isChecked()) {
            selectedCheckboxes.append("Checkbox 4, ");
        }

        if (checkBox5.isChecked()) {
            selectedCheckboxes.append("Checkbox 5, ");
        }

        Toast.makeText(this, selectedCheckboxes.toString(), Toast.LENGTH_SHORT).show();
    }
}
