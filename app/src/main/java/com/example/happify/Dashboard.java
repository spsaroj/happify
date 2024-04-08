package com.example.happify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
//        Button loadProject = findViewById(R.id.button);
//        loadProject.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), SignIn.class);
//                startActivity(intent);
//            }
//        });
    }

    public void guidedBreathingBtnOnClick(View v){
        Intent gbIntent = new Intent(getApplicationContext(), GuidedBreathing.class);
        startActivity(gbIntent);
    }
    public void journalBtnOnClick(View v){
        Intent journalIntent = new Intent(getApplicationContext(), JournalList.class);
        startActivity(journalIntent);
    }
    public void moodTrackingBtnOnClick(View v){
        Intent mtIntent = new Intent(getApplicationContext(), MoodTracking.class);
        startActivity(mtIntent);
    }
    public void profileBtnOnClick(View v){
        Intent profileIntent = new Intent(getApplicationContext(), Profile.class);
        startActivity(profileIntent);
    }
    public void pointsBtnOnClick(View v){
        Intent pointsIntent = new Intent(getApplicationContext(), Points.class);
        startActivity(pointsIntent);
    }
    public void telusClicked(View v){
        String url = "https://myssp.app/us/explore/allCategories";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
    public void suicideHelplineClicked(View v){
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "988"));
        startActivity(intent);
    }
}