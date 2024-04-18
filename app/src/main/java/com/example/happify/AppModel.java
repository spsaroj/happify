package com.example.happify;

import com.google.firebase.database.DatabaseReference;

public class AppModel {
    private DatabaseReference mDatabase;
    private static AppModel appModel = null;

    public AppDataModel appdata = null;

    public static AppModel getAppModel(){
        if (appModel == null) {appModel = new AppModel();}
        return appModel;
    }

    public AppModel() {
        int pointTemp = 300;
        int progress = 0;
        int soundsUnlocked = 1;
        appdata = new AppDataModel(pointTemp, progress, soundsUnlocked);
    }

    public static class AppDataModel {
        private int points;
        private int progress;
        private int soundsUnlocked;

        public AppDataModel(int points, int progress, int soundsUnlocked) {
            this.points = points;
            this.progress = progress;
            this.soundsUnlocked = soundsUnlocked;
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

        public void setPoints(int points) {
            this.points = points;
        }

        public void setProgress(int progress) {
            this.progress = progress;
        }

        public void setSoundsUnlocked(int soundsUnlocked) {
            this.soundsUnlocked = soundsUnlocked;
        }
    }

}
