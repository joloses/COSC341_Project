package com.example.cosc341_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Entry_Screen extends AppCompatActivity {

    Button es_button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry_screen);

        // set button
        es_button = findViewById(R.id.ES_GetStarted);
        es_button.setText("CREATE AN ACCOUNT");
        es_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent es_intent = new Intent(Entry_Screen.this, Create_Acc_Screen1.class);
                startActivity(es_intent);
            }
        });
    }
}