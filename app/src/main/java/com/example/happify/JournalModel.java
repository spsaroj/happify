package com.example.happify;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class JournalModel {
    private DatabaseReference mDatabase;
    private static JournalModel theModel = null;
    public ArrayList<Journal> journals = null;
    public static JournalModel getModel() {
        if (theModel == null) {theModel = new JournalModel();}
        return theModel;
    }
    private JournalModel() {
        journals = new ArrayList<>();
        this.loadData();
    }
    private void loadData() {
        this.journals.add(new Journal("this is a journal"));
        this.journals.add(new Journal("this is another journal"));
        this.journals.add(new Journal("this is yet another journal"));
    }
    public static class Journal {
        private String journalItem;
        public Journal(String journalItem){
            this.journalItem =journalItem;
        }
        public String getJournalItem() {
            return this.journalItem;
        }

        public void setJournalItem(String journalItem) {
            this.journalItem = journalItem;
        }
    }
}