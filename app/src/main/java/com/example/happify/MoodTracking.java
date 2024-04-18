package com.example.happify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
                String currentMood = "You are sad.";
                TextView currentMoodET = findViewById(R.id.mtWriteAbtIt);
                String currentMoodSt = "Do you want to write about it?";
                String currentMoodToSet = currentMood+"\n"+currentMoodSt;
                currentMoodET.setText(currentMoodToSet);
            }
        });

        moodButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle mood button 2 click
                String currentMood = "You are feeling neutral.";
                TextView currentMoodET = findViewById(R.id.mtWriteAbtIt);
                String currentMoodSt = "Do you want to write about it?";
                String currentMoodToSet = currentMood+"\n"+currentMoodSt;
                currentMoodET.setText(currentMoodToSet);
            }
        });

        moodButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle mood button 3 click
                String currentMood = "You are feeling happy.";
                TextView currentMoodET = findViewById(R.id.mtWriteAbtIt);
                String currentMoodSt = "Do you want to write about it?";
                String currentMoodToSet = currentMood+"\n"+currentMoodSt;
                currentMoodET.setText(currentMoodToSet);
            }
        });

        moodButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle mood button 4 click
                String currentMood = "You are feeling Fantastic.";
                TextView currentMoodET = findViewById(R.id.mtWriteAbtIt);
                String currentMoodSt = "Do you want to write about it?";
                String currentMoodToSet = currentMood+"\n"+currentMoodSt;
                currentMoodET.setText(currentMoodToSet);
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
        finish();
    }
}