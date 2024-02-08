package com.example.hello2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private StringBuilder inputStringBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);
        inputStringBuilder = new StringBuilder();
    }

    public void onDigitClick(View view) {
        Button button = (Button) view;
        inputStringBuilder.append(button.getText());
        updateResult();
    }

    public void onOperatorClick(View view) {
        Button button = (Button) view;
        inputStringBuilder.append(" ").append(button.getText()).append(" ");
        updateResult();
    }

    public void onDecimalClick(View view) {
        if (!inputStringBuilder.toString().contains(".")) {
            inputStringBuilder.append(".");
            updateResult();
        }
    }

    public void onEqualsClick(View view) {
        try {
            String input = inputStringBuilder.toString();
            String[] values = input.split(" ");
            double result = evaluateExpression(values);
            resultTextView.setText(String.valueOf(result));
            inputStringBuilder.setLength(0);
            inputStringBuilder.append(result);
        } catch (Exception e) {
            resultTextView.setText("Error");
            inputStringBuilder.setLength(0);
        }
    }

    public void onClearClick(View view) {
        inputStringBuilder.setLength(0);
        resultTextView.setText("");
    }

    private void updateResult() {
        resultTextView.setText(inputStringBuilder.toString());
    }

    private double evaluateExpression(String[] values) {
        double num1 = Double.parseDouble(values[0]);
        String operator = values[1];
        double num2 = Double.parseDouble(values[2]);

        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "X":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    throw new ArithmeticException("Division by zero");
                }
            default:
                throw new UnsupportedOperationException("Invalid operator");
        }
    }
}
