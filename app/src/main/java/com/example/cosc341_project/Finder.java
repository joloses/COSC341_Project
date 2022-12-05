package com.example.cosc341_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Finder extends AppCompatActivity {

    final private int[] profileImageArray = {R.drawable.ic_user, R.drawable.profile_ray, R.drawable.profile_ksoc};
    private int imgCounter = 0;
    //User user;
    Intent intent;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finder);
        intent = getIntent();
        bundle = intent.getExtras();
        loadUser();
        ImageView profileImage = findViewById(R.id.profile_image);
        profileImage.setImageDrawable(getDrawable(profileImageArray[imgCounter]));

      //  user = (User) getIntent().getSerializableExtra("user");

        setProfileText();
    }

    public void toChat(View view){
        Intent intent = new Intent(Finder.this, Chat.class);
        //intent.putExtra("user",user);
        startActivity(intent);
    }


    public void toSettings(View view){
        Intent intent = new Intent(Finder.this, Settings_Preferences.class);
        //intent.putExtra("user",user);
        startActivity(intent);
    }

    public void onProfileClick(View v){
        //Intent i = new Intent(Finder.this, FriendProfile.class);
        //i.putExtra("user",user);
        TextView profileName = findViewById(R.id.profile_name);
        String name = profileName.getText().toString();
        String nameFormat = this.getString(R.string.user_name, name);
        //i.putExtra("name", nameFormat);

        //startActivity(i);
    }

    public void onNextClick(View v){
        ImageView profileImage = findViewById(R.id.profile_image);
        if (imgCounter != profileImageArray.length-1)  profileImage.setImageDrawable(getDrawable(profileImageArray[++imgCounter]));
        setProfileText();
    }
//
    public void onBackClick(View v){
        ImageView profileImage = findViewById(R.id.profile_image);
        if (imgCounter != 0)  profileImage.setImageDrawable(getDrawable(profileImageArray[--imgCounter]));
        setProfileText();
    }
//
    public void setProfileText(){
        TextView profileName = findViewById(R.id.profile_name);
        String format;
        if (profileImageArray[imgCounter] == R.drawable.ic_user){
            String name = this.getResources().getString(R.string.name_susan);
            format = this.getString(R.string.user_name, name);
            profileName.setText(format);
        }
        if (profileImageArray[imgCounter] == R.drawable.profile_ray){
            String name = this.getResources().getString(R.string.name_ray);
            format = this.getString(R.string.user_name, name);
            profileName.setText(format);
        }
        if (profileImageArray[imgCounter] == R.drawable.profile_ksoc){
            String name = this.getResources().getString(R.string.name_ksoc);
            format = this.getString(R.string.user_name, name);
            profileName.setText(format);
        }
    }

    private boolean loadUser(){
        File sourceFile = new File(getApplicationContext().getFilesDir(), "text");
        if(!sourceFile.exists()){
            return false;
        }else {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFile + "/user.txt"))) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return false;
                } else {
                    String[] userData = line.split("@@@");
                    Date birthday;
                    if(!userData[6].equals("null")){
                        birthday = new SimpleDateFormat("dd/MM/yyyy", Locale.CANADA).parse(userData[6]);
                    }else{
                        birthday = null;
                    }
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
        }
    }

}
