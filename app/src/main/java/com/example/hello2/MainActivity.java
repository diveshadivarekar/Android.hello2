package com.example.hello2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button changeImageButton;

    private int[] images = {R.drawable.img, R.drawable.img_1};
    private int currentImageIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        changeImageButton = findViewById(R.id.changeImageButton);

        setImage(images[currentImageIndex]);

        changeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Change the image when the button is clicked
                currentImageIndex = (currentImageIndex + 1) % images.length;
                setImage(images[currentImageIndex]);
            }
        });
    }

    private void setImage(int resourceId) {
        imageView.setImageResource(resourceId);
    }
}
