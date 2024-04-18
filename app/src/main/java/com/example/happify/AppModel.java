package com.example.happify;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import org.checkerframework.checker.units.qual.A;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AppModel {
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private static AppModel appModel = null;

    public AppDataModel appdata = null;

    public ArrayList<AppModel.Journal> journals = null;

    public static AppModel getAppModel(){
        if (appModel == null) {appModel = new AppModel();}
        return appModel;
    }

    public AppModel() {
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        final int[] pointTemp = {0};
//        final int[] progress = {0};
//        final int[] soundsUnlocked = {1};
//
//        if(currentUser != null){
//            String userId = currentUser.getUid();
//            DatabaseReference userRef = mDatabase.child("users").child(userId);
//            userRef.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot snapshot) {
//                    for (DataSnapshot sn : snapshot.getChildren()) {
//                        AppDataModel appData = snapshot.getValue(AppDataModel.class);
//                        if (appData != null) {
//                            pointTemp[0] = appData.getPoints();
//                            progress[0] = appData.getProgress();
//                            soundsUnlocked[0] = appData.getSoundsUnlocked();
//                            journalsFB = appData.getJournals();
//                        }
//                    }
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError error) {
//
//                }
//            })
//
//        }
//
        int point = 200;
        int progress = 0;
        int soundsUnlocked = 1;
        journals = new ArrayList<>();
        appdata = new AppDataModel(point, progress, soundsUnlocked, journals);
    }

    public static class AppDataModel {
        private int points;
        private int progress;
        private int soundsUnlocked;
        private ArrayList<Journal> journals;
        public AppDataModel(int points, int progress, int soundsUnlocked, ArrayList<Journal> journals) {
            this.points = points;
            this.progress = progress;
            this.soundsUnlocked = soundsUnlocked;
            this.journals = journals;
        }

        public int getPoints() {
            return this.points;
        }

        public int getProgress() {
            return this.progress;
        }

        public int getSoundsUnlocked() {
            return this.soundsUnlocked;
        }

        public ArrayList<Journal> getJournals() {
            return this.journals;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public void setProgress(int progress) {
            this.progress = progress;
        }

        public void setSoundsUnlocked(int soundsUnlocked) {
            this.soundsUnlocked = soundsUnlocked;
        }

        public void setJournals(ArrayList<Journal> journals) {
            this.journals = journals;
        }
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
