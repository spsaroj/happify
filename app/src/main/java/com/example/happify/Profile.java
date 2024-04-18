package com.example.happify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class Profile extends AppCompatActivity {

    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        TextView nameTV = findViewById(R.id.nameTVProfile);
        TextView emailTV = findViewById(R.id.emailTVProfile);

        nameTV.setText(user.getDisplayName());
        emailTV.setText(user.getEmail());
    }
    public void onBackPressedProfile(View v){
        finish();
    }
    public void onLogOutPressed(View v){
        auth.getInstance().signOut();
        Intent intent = new Intent(getApplicationContext(), SignIn.class);
        startActivity(intent);
    }
}