package com.example.happify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class JournalList extends AppCompatActivity {
    JournalAdapter journalServer;
    private boolean writingIsComplete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_list);

         journalServer = new JournalAdapter();
        RecyclerView journalRV = findViewById(R.id.journalRV);
        journalRV.setAdapter(journalServer);
        LinearLayoutManager myManager = new LinearLayoutManager(this);
        journalRV.setLayoutManager(myManager);
        if (getIntent().hasExtra("writingIsComplete")) {
            writingIsComplete = getIntent().getBooleanExtra("writingIsComplete", false);
        }
        else{
            writingIsComplete = false;
        }

        // Now you can use writingIsComplete as needed
        if (writingIsComplete) {
            journalServer.notifyItemInserted(AppModel.getAppModel().journals.size()-1);
        }
    }
    public void onBackPressedJL(View v){
        finish();
    }
    public void onNewJournalPressedJL(View v){

        Intent intent = new Intent(this, JournalWrite.class);
        startActivity(intent);
    }
}