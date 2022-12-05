package com.example.cosc341_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Search extends AppCompatActivity {

    // if opened for the first time
    //      show everyone
    // else
    //      show "No one new to discover"

    String[] names = {"Some Guy", "Another Guy", "Third Guy"};
    String[] descs = {"I like cats and memes in russian",
            "Basketball and making projects",
            "I like football and my dog"};

    Integer[] image = {R.drawable.rzhenie, R.drawable.profile_icon, R.drawable.beer};
    int point = 0;

    LinearLayout profile_card;
    ImageView profile_pic;
    TextView name;
    TextView desc;

    Button like;
    Button dislike;
    Global data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        profile_card = findViewById(R.id.profile_card);
        profile_pic = findViewById(R.id.profile_image);
        name = findViewById(R.id.name);
        desc = findViewById(R.id.desc);
        like = findViewById(R.id.like);
        dislike = findViewById(R.id.dislike);

        data = Global.getInstance(); // separate class to hold number of connections
        if(!data.isFirst())
            hide();
    }

    public void hide() {
        profile_card.setVisibility(View.GONE);
        like.setVisibility(View.GONE);
        dislike.setVisibility(View.GONE);
    }

    public void like(View v) {
        switch (point) {
            case 0:
                data.setOne();
                break;
            case 1:
                data.setTwo();
                break;
            case 2:
                data.setThree();
                break;
        }
        if(point < 2) {
            point++;
            profile_pic.setImageResource(image[point]);
            name.setText(names[point]);
            desc.setText(descs[point]);
        }
        else {
            // show "No one" text
            data.changeFirst();
            hide();
        }
    }

    public void dislike(View v) {
        if(point < 2) {
            point++;
            profile_pic.setImageResource(image[point]);
            name.setText(names[point]);
            desc.setText(descs[point]);
        }
        else {
            // show "No one" text
            data.changeFirst();
            hide();
        }
    }

    /*
    public void openProfile(View view) {

    }
     */

    public void toChat(View view) {
        Intent intent = new Intent(this, Chat_List.class);
        startActivity(intent);
    }
    // methods for dock buttons
    /*
    public void toGroups(View view) {
        Intent intent = new Intent(this, Groups.class);
        startActivity(intent);
    }

    public void toProfile(View view) {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }
     */
}