package com.example.happify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class Dashboard extends AppCompatActivity {

    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private String quotesUrl = "https://type.fit/api/quotes";

    TextView quoteTV;
    String quotesString;
    ArrayList<QuoteModel> quotes;
    int quotePosition;
    TextView pointsDashboardTV;
    int userProgress;
    ProgressBar progress1;
    ProgressBar progress2;
    ProgressBar progress3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //Points section
        pointsDashboardTV = findViewById(R.id.pointsAmountTV);
        pointsDashboardTV.setText(Integer.toString(AppModel.getAppModel().appdata.getPoints()));

        //Quotes Section
        quoteTV = findViewById(R.id.authorMotivationDashboard);
        quoteTV.setText("Be happy with Happify\nHappify Team");
        quotes = new ArrayList<>();
        getData();

        //ProgressBar section
        userProgress = AppModel.getAppModel().appdata.getProgress();
        progress1 = findViewById(R.id.progressBarOne);
        progress2 = findViewById(R.id.progressBarTwo);
        progress3 = findViewById(R.id.progressBarThree);
        if(userProgress == 0 || userProgress>3){
            progress1.setProgress(0);
            progress2.setProgress(0);
            progress3.setProgress(0);
        } else if (userProgress == 1) {
            progress1.setProgress(100);
            progress2.setProgress(0);
            progress3.setProgress(0);
        } else if (userProgress == 2) {
            progress1.setProgress(100);
            progress2.setProgress(100);
            progress3.setProgress(0);
        }
        else{
            progress1.setProgress(100);
            progress2.setProgress(100);
            progress3.setProgress(100);
        }
        TextView progressTextDashboard = findViewById(R.id.progressTextDashboard);
        if(userProgress == 3){
            progressTextDashboard.setText("You completed today's task!");
        }
        else {
            progressTextDashboard.setText("You are almost there!");
        }

        //

    }

    @Override
    protected void onResume() {
        super.onResume();
        pointsDashboardTV.setText(Integer.toString(AppModel.getAppModel().appdata.getPoints()));
        userProgress = AppModel.getAppModel().appdata.getProgress();
        progress1 = findViewById(R.id.progressBarOne);
        progress2 = findViewById(R.id.progressBarTwo);
        progress3 = findViewById(R.id.progressBarThree);
        if(userProgress == 0 || userProgress>3){
            progress1.setProgress(0);
            progress2.setProgress(0);
            progress3.setProgress(0);
        } else if (userProgress == 1) {
            progress1.setProgress(100);
            progress2.setProgress(0);
            progress3.setProgress(0);
        } else if (userProgress == 2) {
            progress1.setProgress(100);
            progress2.setProgress(100);
            progress3.setProgress(0);
        }
        else{
            progress1.setProgress(100);
            progress2.setProgress(100);
            progress3.setProgress(100);
        }
        TextView progressTextDashboard = findViewById(R.id.progressTextDashboard);
        if(userProgress == 3){
            progressTextDashboard.setText("You completed today's task!");
        }
        else {
            progressTextDashboard.setText("You are almost there!");
        }
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

    public void newQuoteBtnClicked(View v){
        if(AppModel.getAppModel().appdata.getPoints() <30){
            Toast.makeText(getApplicationContext(), "You don't have enough coins", Toast.LENGTH_SHORT).show();
        }
        else{
            //deduct the coin in model
            AppModel.getAppModel().appdata.setPoints(AppModel.getAppModel().appdata.getPoints() - 30);
            pointsDashboardTV.setText(Integer.toString(AppModel.getAppModel().appdata.getPoints()));

            //replace the motivation quote:
            String toInsert = quotes.get(quotePosition).getQuoteText();
            quoteTV.setText(toInsert);

        }
    }
    private void getData() {
        // RequestQueue initialized
        mRequestQueue = Volley.newRequestQueue(this);


        // String Request initialized
        mStringRequest = new StringRequest(Request.Method.GET, quotesUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("response api", response.getClass().getName());

                Gson gson = new Gson();
                QuoteModel [] quotesArray = gson.fromJson(response, QuoteModel[].class);

                quotes = new ArrayList<>();
                for (QuoteModel quote : quotesArray) {
                    quotes.add(quote);
                }
                quotePosition = new Random().nextInt(quotesArray.length-1);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Error occurred", "Error :" + error.toString());
            }
        });

        mRequestQueue.add(mStringRequest);

    }
}