package com.example.happify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class JournalList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_list);

        JournalAdapter journalServer = new JournalAdapter();
        RecyclerView journalRV = findViewById(R.id.journalRV);
        journalRV.setAdapter(journalServer);
        LinearLayoutManager myManager = new LinearLayoutManager(this);
        journalRV.setLayoutManager(myManager);
    }
}