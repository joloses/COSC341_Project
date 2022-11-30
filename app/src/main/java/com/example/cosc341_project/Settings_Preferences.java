package com.example.cosc341_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class Settings_Preferences extends AppCompatActivity {

    //Initialize variables
    Button infoPage, signOut;
    SeekBar distanceBar;
    TextView distanceVal;
    EditText editMinAge, editMaxAge;
    Spinner genderSpinner, levelSpinner;
    int distanceChosen, minAgeChosen, maxAgeChosen;
    String genderChosen, levelChosen;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_preferences);

        //Gather distance here, change distanceVal as seek bar moves.
        distanceBar = findViewById(R.id.distanceBar);
        distanceBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                distanceVal =(TextView)findViewById(R.id.distanceBarVal);
                distanceVal.setText(i + " km");
                distanceChosen = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Gather min and max age data here, take input as string and convert to Integer
        editMinAge = findViewById(R.id.editMinAge);
        String tempMinAge = editMinAge.getText().toString();
        minAgeChosen = Integer.parseInt(tempMinAge);

        editMaxAge = findViewById(R.id.editMaxAge);
        String tempMaxAge = editMaxAge.getText().toString();
        maxAgeChosen = Integer.parseInt(tempMaxAge);


        //Put gender choices in spinner and gather chosen option
        String[] genderArray = new String[] {"No Preference" , "Male" , "Female"};
        genderSpinner = findViewById(R.id.genderSpinner);
        ArrayAdapter<String> genderAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, genderArray);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(genderAdapter);
        genderChosen = genderSpinner.getSelectedItem().toString();

        //Put level of play choices in spinner and gather chosen option
        String[] levelArray = new String[] {"Casual/Fun" , "Training" , "(Semi) Pro"};
        levelSpinner = findViewById(R.id.levelSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, levelArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        levelSpinner.setAdapter(adapter);
        levelChosen = levelSpinner.getSelectedItem().toString();

        //Set up information page here -> intent to new activity


        //Set up signout page here -> intent to pop up confirming action then bring to main page (finish())

    }

}