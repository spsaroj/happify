package com.example.happify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SignIn extends AppCompatActivity {

    private ImageView submitLogo;
    private TextView signInWithGoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

    }
    public void onSigninPressed(View v){
        Intent signinIntent = new Intent(this, Dashboard.class);
        startActivity(signinIntent);
    }
}