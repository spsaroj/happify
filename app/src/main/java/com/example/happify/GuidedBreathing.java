package com.example.happify;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Locale;

public class GuidedBreathing extends AppCompatActivity {
    TextView countdownTimer;
    CountDownTimer timer;
    Button start;

    Spinner dropDown;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guided_breathing);

        dropDown=findViewById(R.id.dropDown);
        String[] soundsList= {"Ocean Waves", "River", "Birds", "Rain Thunder"};
        ArrayList<String> soundsBreathing = new ArrayList<>();

        for (int i = 0; i < 2; i++){
            soundsBreathing.add(soundsList[i]);
        }


        ArrayAdapter adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, soundsBreathing.toArray());

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        dropDown.setAdapter(adapter);

        countdownTimer=findViewById(R.id.displayCount);
        start=findViewById(R.id.startCountBtn);
        dropDown=findViewById(R.id.dropDown);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTime();
            }
        });
    }

    private void startTime() {
        timer=new CountDownTimer(60000, 1000) {

            @Override
            public void onTick(long l) {
//                MediaPlayer backgroundMusic =
                long hours=(l/1000)/3600;
                long minutes=((l/1000)%3600)/60;
                long seconds=(l/1000)%60;
                String timeFormatted=String.format(Locale.getDefault(),"%02d:%02d", minutes,seconds);
                countdownTimer.setText(timeFormatted);
            }

            @Override
            public void onFinish() {
                countdownTimer.setText("00:00");

            }
        }.start();
    }

    public void onBackPressedGB(View v){
        finish();
    }
}