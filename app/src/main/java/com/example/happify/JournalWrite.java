package com.example.happify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
                if(journalWriteString.length() > 0){
                    AppModel.getAppModel().journals.add(new AppModel.Journal(journalWriteString));

                    Intent intent = new Intent(getApplicationContext(), JournalList.class);
                    AppModel.getAppModel().appdata.setPoints(AppModel.getAppModel().appdata.getPoints() + 10);
                    AppModel.getAppModel().appdata.setProgress(AppModel.getAppModel().appdata.getProgress() + 1);
                    intent.putExtra("writingIsComplete", true);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Write something", Toast.LENGTH_SHORT).show();
                }
            }

    }