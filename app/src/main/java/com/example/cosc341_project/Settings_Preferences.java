package com.example.cosc341_project;

import android.app.Notification;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class Settings_Preferences extends AppCompatActivity {

    //Buttons
    Button signOutBtn, toProfileBtn, infoBtn;

    // Age & Distance Variables
    EditText editMinAge, editMaxAge, editDistance;
    //Spinners
    Spinner genderSpinner, levelSpinner;
    //Chosen Variables
    int distanceChosen, minAgeChosen, maxAgeChosen;
    String genderChosen, levelChosen;
    //Notification Variables
    Switch notification;
    static boolean notifOn;
    //Store data
    Bundle settingsBundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_preferences);

        settingsBundle = new Bundle();

        //Gather distance data here
        editDistance = findViewById(R.id.editDistance);
        distanceChosen = Integer.parseInt(editDistance.getText().toString());
        settingsBundle.putInt("Distance", distanceChosen);


        //Gather min and max age data here, take input as string and convert to Integer
        editMinAge = findViewById(R.id.editMinAge);
        String tempMinAge = editMinAge.getText().toString();

        minAgeChosen = Integer.parseInt(tempMinAge);
        settingsBundle.putInt("Minimum Age", minAgeChosen);

        editMaxAge = findViewById(R.id.editMaxAge);
        String tempMaxAge = editMaxAge.getText().toString();

        maxAgeChosen = Integer.parseInt(tempMaxAge);
        settingsBundle.putInt("Maximum Age", maxAgeChosen);

        //Put gender choices in spinner and gather chosen option
        String[] genderArray = new String[]{"No Preference", "Male", "Female"};
        genderSpinner = findViewById(R.id.genderSpinner);
        ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, genderArray);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(genderAdapter);

        genderChosen = genderSpinner.getSelectedItem().toString();
        settingsBundle.putString("Gender", genderChosen);

        //Put level of play choices in spinner and gather chosen option
        String[] levelArray = new String[]{"Casual/Fun", "Training", "(Semi) Pro"};
        levelSpinner = findViewById(R.id.levelSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, levelArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        levelSpinner.setAdapter(adapter);

        levelChosen = levelSpinner.getSelectedItem().toString();
        settingsBundle.putString("Level", levelChosen);

        signOutBtn = findViewById(R.id.signOutBtn);
        toProfileBtn = findViewById(R.id.toProfileBtn);
        infoBtn = findViewById(R.id.aboutBtn);
        notification = findViewById(R.id.switchNotif);

        signOutBtn.setOnClickListener(this::signOutConfirm);
        toProfileBtn.setOnClickListener(this::backToProfile);
        infoBtn.setOnClickListener(this::toInfoContact);
        notification.setOnClickListener(this::toggleNotifications);


    }


    //Notifications Tab (Fake notification for design purposes)
    public void toggleNotifications(View v) {

        if (notification.isChecked()) {
            notifOn = true;
            sendNotification(this, "Team Up", "Notifications is On");
        } else {
            notifOn = false;
            Toast.makeText(this, "Notifications is Off", Toast.LENGTH_SHORT).show();
        }
    }

    public void sendNotification(Context context, String contentTitle, String contentText) {
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        if (notifOn) {
            Notification notification = new NotificationCompat.Builder(this, notifChannel.CHANNEL_ID_1)
                    .setContentTitle(contentTitle)
                    .setContentText(contentText)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setCategory(NotificationCompat.CATEGORY_STATUS)
                    .build();
            notificationManager.notify(1, notification);
        }
    }


    //Set up information page here -> intent to new activity
    public void toInfoContact(View v) {
        Intent intent = new Intent(Settings_Preferences.this, App_Information.class);
        startActivity(intent);
    }

    //Set up signout page here -> intent to pop up confirming action then bring to main page (finish())
    public void signOutConfirm(View v) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setTitle("Confirm Sign Out");
        alertDialogBuilder.setMessage("Are you sure,You want to sign out?");
        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                finish();
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void backToProfile(View v) {
        Intent intent = new Intent(Settings_Preferences.this, Profile.class);
        intent.putExtras(settingsBundle);
        startActivity(intent);
    }


}