package com.example.happify;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Signin extends AppCompatActivity {

    private ImageView submitLogo;
    private TextView signInWithGoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        ImageView logoImageView = findViewById(R.id.logo);
        submitLogo  = findViewById(R.id.submitLogo);
        signInWithGoogle = findViewById(R.id.SignInWithGoogle);

        // Set click listener for the submitLogo ImageView
        submitLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the Firebase authentication function here

            }
        });
    }
}
