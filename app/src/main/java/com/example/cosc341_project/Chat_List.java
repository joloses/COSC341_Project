package com.example.cosc341_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Chat_List extends AppCompatActivity {

    // need to get info about connections

    TextView empty;
    LinearLayout block1;
    LinearLayout block2;
    LinearLayout block3;

    TextView name1;
    TextView name2;
    TextView name3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);

        block1 = findViewById(R.id.block1);
        block2 = findViewById(R.id.block2);
        block3 = findViewById(R.id.block3);

        name1 = findViewById(R.id.name1);
        name2 = findViewById(R.id.name2);
        name3 = findViewById(R.id.name3);

        empty = findViewById(R.id.emptyTV);

        /*
        if connections = 0
            show empty textview
        if connections = n
            hide empty textview
            show n blocks
         */
    }

    // methods for dock buttons
    /*
    public void toGroups(View view) {
        Intent intent = new Intent(this, Groups.class);
        startActivity(intent);
    }

    public void toSearch(View view) {
        Intent intent = new Intent(this, Search.class);
        startActivity(intent);
    }

    public void toProfile(View view) {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }
     */
}