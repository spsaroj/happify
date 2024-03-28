package com.example.happify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Signin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        ImageView logoImageView = findViewById(R.id.logo);
        Button googleSignInButton = findViewById(R.id.googleSignInButton);

        // Set onClick listener for Google sign-in button
        googleSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the Firebase authentication function here
                // Replace this comment with your authentication logic
            }
        });
    }
}
