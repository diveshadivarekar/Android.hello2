package com.example.hello2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextStudentName, editTextEnrollmentNumber, editTextDepartment, editTextYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextStudentName = findViewById(R.id.editTextStudentName);
        editTextEnrollmentNumber = findViewById(R.id.editTextEnrollmentNumber);
        editTextDepartment = findViewById(R.id.editTextDepartment);
        editTextYear = findViewById(R.id.editTextYear);

        Button buttonRegister = findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRegisterClick(v);
            }
        });
    }

    public void onRegisterClick(View view) {
        String studentName = editTextStudentName.getText().toString().trim();
        String enrollmentNumber = editTextEnrollmentNumber.getText().toString().trim();
        String department = editTextDepartment.getText().toString().trim();
        String yearStr = editTextYear.getText().toString().trim();

        if (studentName.isEmpty() || enrollmentNumber.isEmpty() || department.isEmpty() || yearStr.isEmpty()) {
            showToast("Please fill in all fields.");
        } else {
            int year = Integer.parseInt(yearStr);

            showToast("Registration successful!\n" +
                    "Name: " + studentName + "\n" +
                    "Enrollment Number: " + enrollmentNumber + "\n" +
                    "Department: " + department + "\n" +
                    "Year: " + year);
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
