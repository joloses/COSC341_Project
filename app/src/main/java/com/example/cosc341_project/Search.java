package com.example.cosc341_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

    // arrays for names, descriptions and profile images
    String[] names = {"Some Guy", "Another Guy", "Third Guy"};
    String[] descs = {"I like cats and memes in russian",
            "Basketball and making projects",
            "I like football and my dog"};
    Integer[] image = {R.drawable.rzhenie, R.drawable.profile_icon, R.drawable.beer};
    int point = 0;  // pointer to the current profile to display

    // get views
    LinearLayout profile_card;
    ImageView profile_pic;
    TextView name;
    TextView desc;
    TextView last;
    Button like;
    Button dislike;

    // to store connections data
    Global data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // get views
        profile_card = findViewById(R.id.profile_card);
        profile_pic = findViewById(R.id.profile_image);
        name = findViewById(R.id.name);
        desc = findViewById(R.id.desc);
        last = findViewById(R.id.last);
        like = findViewById(R.id.like);
        dislike = findViewById(R.id.dislike);

        data = Global.getInstance(); // initialise global data if null
        if(!data.isFirst()) {   // if all profiles are liked/disliked, don't show anything
            last.setVisibility(View.VISIBLE);
            hide();
        }
        else if(data.getPoint() != 0) { // else start from the point activity was left at
            point = data.getPoint();
            last.setVisibility(View.INVISIBLE);
            profile_pic.setImageResource(image[point]);
            name.setText(names[point]);
            desc.setText(descs[point]);
        }
    }

    // hide profile card and like/dislike buttons
    public void hide() {
        profile_card.setVisibility(View.GONE);
        like.setVisibility(View.GONE);
        dislike.setVisibility(View.GONE);
    }

    // like button onClick
    public void like(View v) {
        switch (point) {    // depending on the current point, add connection to the data
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
        if(point < 2) {     // if point != end of array, show next profile
            point++;
            profile_pic.setImageResource(image[point]);
            name.setText(names[point]);
            desc.setText(descs[point]);
            data.setPoint(point);
        }
        else {              // else hide profile card + buttons
            last.setVisibility(View.VISIBLE);
            data.changeFirst();
            hide();
        }
    }

    // dislike button onClick, same as like, but doesn't add connection
    public void dislike(View v) {
        if(point < 2) {
            point++;
            profile_pic.setImageResource(image[point]);
            name.setText(names[point]);
            desc.setText(descs[point]);
        }
        else {
            last.setVisibility(View.VISIBLE);
            data.changeFirst();
            hide();
        }
    }

    // to handle openProfile method and not to create a new activity instance
    @SuppressLint("MissingSuperCall")
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {}

    // opens other's person profile
    public void openProfile(View view) {
        Intent intent = new Intent(this, SeeProfile.class);
        intent.putExtra("num", Integer.toString(point));
        startActivity(intent);
    }

    // dock navigation methods
    public void toChat(View view) {
        Intent intent = new Intent(this, Chat_List.class);
        startActivity(intent);
    }

    public void toProfile(View view) {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }
}