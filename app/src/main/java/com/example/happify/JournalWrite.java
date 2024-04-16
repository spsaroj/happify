package com.example.happify;

import static com.example.happify.R.id.journalwriteETJournal;
import static com.example.happify.R.id.sumbitET;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class JournalWrite extends AppCompatActivity {

            EditText journalWriteET;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_journal_list);

                // Initialize UI components
                journalWriteET = findViewById(R.id.journalwriteETJournal);
                String journalWriteString = journalWriteET.getText().toString();

            }

            // Method to handle back button click
            public void onBackPressedJL(View view) {
                // Add your back button functionality here
            }

            public void onSubmitPressedJW(View view){
                //Intent int = new Intent(getApplicationContext(), )
            }

    }