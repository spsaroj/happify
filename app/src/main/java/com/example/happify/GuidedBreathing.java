package com.example.happify;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import org.checkerframework.checker.index.qual.LengthOf;
import org.checkerframework.checker.units.qual.A;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class GuidedBreathing extends AppCompatActivity {
    TextView countdownTimer;
    CountDownTimer timer;
    Button start;

    Spinner dropDown;
    String musicUrl;
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guided_breathing);

        dropDown=findViewById(R.id.dropDown);
        String[] soundsList= {"Ocean Waves", "River", "Birds", "Rain Thunder"};
        HashMap<String, String> meditationMusic = new HashMap<>();
        meditationMusic.put("Ocean Waves", "gs://happify-260c7.appspot.com/ocean_waves.mp3");
        meditationMusic.put("River", "gs://happify-260c7.appspot.com/river.mp3");
        meditationMusic.put("Birds", "gs://happify-260c7.appspot.com/nature.mp3");
        meditationMusic.put("Rain Thunder", "gs://happify-260c7.appspot.com/rain_thunder.mp3");
        ArrayList<String> soundsBreathing = new ArrayList<>();

        for (int i = 0; i < 2; i++){
            soundsBreathing.add(soundsList[i]);
        }


        ArrayAdapter adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, soundsBreathing.toArray());

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        dropDown.setAdapter(adapter);

        dropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedValue = (String) adapterView.getItemAtPosition(i);
                // Now you can use the selectedValue as needed
                // For example, you can get the corresponding URL from your HashMap
                musicUrl = meditationMusic.get(selectedValue);
                // Do something with the selected value or URL
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                musicUrl = meditationMusic.get("Ocean Waves");
            }
        });
        countdownTimer=findViewById(R.id.displayCount);
        start=findViewById(R.id.startCountBtn);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        mediaPlayer = new MediaPlayer();
                        try {
                            Log.d("Music url", musicUrl);
                            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                            mediaPlayer.setDataSource(musicUrl);
                            mediaPlayer.prepare();
                            mediaPlayer.setVolume(1f, 1f);
                            mediaPlayer.start();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                startTime();
            }
        });
    }

    private void startTime() {
        timer=new CountDownTimer(60000, 1000) {

            @Override
            public void onTick(long l) {
                long minutes=((l/1000)%3600)/60;
                long seconds=(l/1000)%60;
                String timeFormatted=String.format(Locale.getDefault(),"%02d:%02d", minutes,seconds);
                countdownTimer.setText(timeFormatted);
            }

            @Override
            public void onFinish() {
                countdownTimer.setText("00:00");
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = new MediaPlayer();
                mediaPlayer.reset();

            }
        }.start();
    }

    public void onBackPressedGB(View v){
        finish();
    }
}