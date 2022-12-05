package com.example.cosc341_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SeeProfile extends AppCompatActivity {

    int num;
    String[] names = {"Some Guy, 19", "Another Guy, 21", "Third Guy, 33"};
    String[] descs = {"Male\nLevel of play\n3 kilometers away\nVoleyball\nIn a group ✓\nI like cats and memes in russian",
                        "Male\nLevel of play\n12 kilometers away\nBasketball\nLove making projects",
                        "Male\nLevel of play\n300 meters away\nFootball and baseball\nBeer enthusiast"};
    Integer[] image = {R.drawable.rzhenie, R.drawable.profile_icon, R.drawable.beer};

    TextView desc;
    TextView name;
    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_profile);

        Intent intent = getIntent();
        num = Integer.parseInt(intent.getStringExtra("num"));

        desc = findViewById(R.id.descTV);
        name = findViewById(R.id.nameTV);
        pic = findViewById(R.id.pic);

        name.setText(names[num]);
        desc.setText(descs[num]);
        pic.setImageResource(image[num]);
    }

    public void back(View view) { finish(); }
}