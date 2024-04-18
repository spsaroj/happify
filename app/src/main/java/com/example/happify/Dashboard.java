package com.example.happify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {

    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private String quotesUrl = "https://type.fit/api/quotes";

    TextView quoteTV;
    String quotesString;
    ArrayList<QuoteModel> quotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        quoteTV = findViewById(R.id.authorMotivationDashboard);
        quoteTV.setText("Be happy with Happify\nHappify Team");

        quotes = new ArrayList<>();
        getData();
//        ProgressBar progress1 = findViewById(R.id.progressBarOne);
//        progress1.setProgress(0);
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

    public void newQuoteBtnClicked(View v){


    }
    private void getData() {
        // RequestQueue initialized
        mRequestQueue = Volley.newRequestQueue(this);


        // String Request initialized
        mStringRequest = new StringRequest(Request.Method.GET, quotesUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("response api", response.getClass().getName());

                quotesString = response;
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