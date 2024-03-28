package com.example.happify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MoodTracking extends AppCompatActivity {

    private Button journalButton, submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_tracking);

       ImageView moodButton1 = findViewById(R.id.moodButton1);
       ImageView moodButton2 = findViewById(R.id.moodButton2);
       ImageView moodButton3 = findViewById(R.id.moodButton3);
       ImageView moodButton4 = findViewById(R.id.moodButton4);
        journalButton = findViewById(R.id.journalButton);
        submitButton = findViewById(R.id.submitButton);

        // Set click listeners for mood buttons
        moodButton1.setOnClickListener(moodButtonClickListener);
        moodButton2.setOnClickListener(moodButtonClickListener);
        moodButton3.setOnClickListener(moodButtonClickListener);
        moodButton4.setOnClickListener(moodButtonClickListener);

        // Set click listener for journal button
        journalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open journal activity or fragment
            }
        });

        // Set click listener for submit button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Submit mood data
            }

        });
    }

    private View.OnClickListener moodButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Handle mood button click
        }
    };
}
