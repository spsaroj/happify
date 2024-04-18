package com.example.happify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class Points extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points);
    }
    public void onBackPressedPoints(View v){
        finish();
    }
    public void unlockMusic(View v){
        if(AppModel.getAppModel().appdata.getPoints() < 100){
            Toast.makeText(getApplicationContext(), "You don't have enough coins", Toast.LENGTH_SHORT).show();
        }
        else{
            if(AppModel.getAppModel().appdata.getSoundsUnlocked() >= 4){
                Toast.makeText(getApplicationContext(), "You have unlocked all music. More music coming soon!", Toast.LENGTH_SHORT).show();
            }
            else{
                //deduct the coin in model
                AppModel.getAppModel().appdata.setPoints(AppModel.getAppModel().appdata.getPoints() - 100);
                Toast.makeText(getApplicationContext(), "New Music Unlocked!!!", Toast.LENGTH_SHORT).show();

                AppModel.getAppModel().appdata.setSoundsUnlocked(AppModel.getAppModel().appdata.getSoundsUnlocked() + 1);
            }
        }
    }

}