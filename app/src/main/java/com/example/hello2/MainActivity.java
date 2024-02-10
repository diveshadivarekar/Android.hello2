package com.example.hello2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private StringBuilder orderDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        orderDetails = new StringBuilder();

        CheckBox checkboxPizza = findViewById(R.id.checkboxPizza);
        CheckBox checkboxCoffee = findViewById(R.id.checkboxCoffee);
        CheckBox checkboxBurger = findViewById(R.id.checkboxBurger);
        Button btnOrder = findViewById(R.id.btnOrder);

        checkboxPizza.setOnCheckedChangeListener((buttonView, isChecked) -> handleCheckboxSelection("Pizza", isChecked));
        checkboxCoffee.setOnCheckedChangeListener((buttonView, isChecked) -> handleCheckboxSelection("Coffee", isChecked));
        checkboxBurger.setOnCheckedChangeListener((buttonView, isChecked) -> handleCheckboxSelection("Burger", isChecked));

        btnOrder.setOnClickListener(v -> showOrderToast());
    }

    private void handleCheckboxSelection(String itemName, boolean isChecked) {
        int price = 0;
        switch (itemName) {
            case "Pizza":
                price = 170;
                break;
            case "Coffee":
                price = 50;
                break;
            case "Burger":
                price = 120;
                break;
        }
        if (isChecked) {
            orderDetails.append(itemName).append(" ").append(price).append("Rs\n");
        }
    }

    private void showOrderToast() {
        if (orderDetails.length() > 0) {
            double total = calculateTotalPrice();
            orderDetails.append("Total - Rs").append(total);

            Toast.makeText(this, orderDetails.toString(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "No items selected", Toast.LENGTH_SHORT).show();
        }
        orderDetails.setLength(0);
    }

    private double calculateTotalPrice() {
        double total = 0;

        total += orderDetails.toString().contains("Pizza") ? 170 : 0;
        total += orderDetails.toString().contains("Coffee") ? 50 : 0;
        total += orderDetails.toString().contains("Burger") ? 120 : 0;

        return total;
    }
}
