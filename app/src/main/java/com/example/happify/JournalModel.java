package com.example.happify;

import java.util.ArrayList;

public class JournalModel {
    private static JournalModel theModel = null;
    public ArrayList<Journal> journals = null;
    public static JournalModel getModel() {
        if (theModel == null) theModel = new JournalModel();
        return theModel;
    }
    private JournalModel() {
        journals = new ArrayList<>();
        loadData();
    }
    private void loadData() {
        Journal p = null;
        p = new Journal("Venus");
        journals.add(p);
        p = new Journal("Mercury");
        journals.add(p);
        p = new Journal("Mars");
        journals.add(p);
    }
    public static class Journal {
        private String journalItem;
        public Journal(String journalItem){
            this.journalItem =journalItem;
        }
        public String getJournalItem() {
            return journalItem;
        }

        public void setJournalItem(String journalItem) {
            this.journalItem = journalItem;
        }
    }
}
