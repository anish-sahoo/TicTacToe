/*
Application Name - App1
Created by - Anish Sahoo
Creation Date - 04/07/2022
 */



package com.anish.app1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class StartingScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_screen);
        Button b = findViewById(R.id.button);
        b.setOnClickListener(view -> {
            Intent intent = new Intent(StartingScreen.this,MainActivity.class);
            startActivity(intent);
        });
    }
}