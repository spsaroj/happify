package com.example.happify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class JournalWrite extends AppCompatActivity {

            String journalWriteString;
            EditText journalWriteET;
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_journal_write);

                // Initialize UI components
                journalWriteET = findViewById(R.id.journalwriteET);
            }

            // Method to handle back button click
            public void onBackPressedJW(View view) {
                // Add your back button functionality here
                finish();
            }

            public void onSubmitPressedJW(View view){
                journalWriteString = journalWriteET.getText().toString();
                finish();
            }

    }