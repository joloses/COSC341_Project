package com.example.cosc341_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class Profile extends AppCompatActivity {

    // get data and views
    Global data;
    TextView name;
    TextView desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // get data and views
        data = Global.getInstance();
        name = findViewById(R.id.nameTV);
        desc = findViewById(R.id.descTV);

        // set name and description
        name.setText(data.fname + " " + data.lname + ", " + data.age);
        desc.setText(data.gender + "\n" + data.sport1 + ", " + data.sport3.toLowerCase(Locale.ROOT));
    }

    public void toSettings(View view) {
        Intent intent = new Intent(this, Settings_Preferences.class);
        startActivity(intent);
    }

    // dock navigation methods
    public void toSearch(View view) {
        Intent intent = new Intent(this, Search.class);
        startActivity(intent);
    }

    public void toChat(View view) {
        Intent intent = new Intent(this, Chat_List.class);
        startActivity(intent);
    }
}