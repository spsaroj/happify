package com.example.happify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MoodTracking extends AppCompatActivity {
    private ImageView moodButton1, moodButton2, moodButton3, moodButton4;
    private Button journalButton;
    private TextView submitET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_tracking);

        // Initialize views
        moodButton1 = findViewById(R.id.moodButton1);
        moodButton2 = findViewById(R.id.moodButton2);
        moodButton3 = findViewById(R.id.moodButton3);
        moodButton4 = findViewById(R.id.moodButton4);
        journalButton = findViewById(R.id.journalButton);
        submitET = findViewById(R.id.sumbitET);
        ImageView submitLogo = findViewById(R.id.googleIcon);

        // Set click listeners for mood buttons
        moodButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle mood button 1 click
            }
        });

        moodButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle mood button 2 click
            }
        });

        moodButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle mood button 3 click
            }
        });

        moodButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle mood button 4 click
            }
        });

        // Set click listener for journal button
        journalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle journal button click
                Intent goToJournalIntent = new Intent(getApplicationContext(), JournalList.class);
                startActivity(goToJournalIntent);
            }
        });
    }
    public void onBackPressedMT(View v){
        finish();
    }

    public void onSubmitMTPressed(View v){

    }
}