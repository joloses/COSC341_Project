package com.example.cosc341_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Chat_List extends AppCompatActivity {

    // get views
    TextView empty;
    LinearLayout block1;
    LinearLayout block2;
    LinearLayout block3;

    TextView name1;
    TextView name2;
    TextView name3;

    // to get connections data
    Global data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);

        data = Global.getInstance();    // get data object

        // get views
        block1 = findViewById(R.id.block1);
        block2 = findViewById(R.id.block2);
        block3 = findViewById(R.id.block3);

        name1 = findViewById(R.id.name1);
        name2 = findViewById(R.id.name2);
        name3 = findViewById(R.id.name3);

        empty = findViewById(R.id.emptyTV);
        if(data.empty())       // if no connections made, hide dialogs
            hideDialog();
        else {                  // else show dialogs + hide text
            showDialog();
            hideText();
        }
    }

    // check connections in data, and show respective dialogs
    public void showDialog() {
        goneDialog();
        if(data.getOne() == 1)
            block1.setVisibility(View.VISIBLE);
        if(data.getTwo() == 1)
            block2.setVisibility(View.VISIBLE);
        if(data.getThree() == 1)
            block3.setVisibility(View.VISIBLE);
    }

    // hide dialogs
    public void hideDialog() {
        block1.setVisibility(View.INVISIBLE);
        block2.setVisibility(View.INVISIBLE);
        block3.setVisibility(View.INVISIBLE);
    }

    // minimize dialogs
    public void goneDialog() {
        block1.setVisibility(View.GONE);
        block2.setVisibility(View.GONE);
        block3.setVisibility(View.GONE);
    }

    // minimize "empty" textview
    public void hideText() {
        TextView aa = findViewById(R.id.emptyTV);
        aa.setVisibility(View.GONE);
    }

    // open chat
    public void openChat(View view) {
        Bundle extras = new Bundle();
        Intent intent = new Intent(this, Chat.class);

        switch (view.getId()) {     // pass profile pic and name
            case R.id.block1:
                extras.putString("name", name1.getText().toString());
                extras.putInt("img", 1);
                break;
            case R.id.block2:
                extras.putString("name", name2.getText().toString());
                extras.putInt("img", 2);
                break;
            case R.id.block3:
                extras.putString("name", name3.getText().toString());
                extras.putInt("img", 3);
                break;
        }
        intent.putExtras(extras);
        startActivityForResult(intent, 1);
    }

    /*
    public void seeProfile(View view) {
        Intent intent = new Intent(this, SeeProfile.class);
        switch (view.getId()) {     // pass profile pic and name
            case R.id.block1:
                intent.putExtra("num", 0);
                break;
            case R.id.block2:
                intent.putExtra("num", 1);
                break;
            case R.id.block3:
                intent.putExtra("num", 2);
                break;
        }
        startActivity(intent);
    }
     */

    // prevents creating another instance of chat_list and show your last message
    @SuppressLint("MissingSuperCall")
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        TextView tv;
        String lastMsg = data.getStringExtra("lastMsg");
        int i = Integer.valueOf(data.getStringExtra("i"));
        switch(i) {
            case 1:
                tv = findViewById(R.id.hi1);
                tv.setText(lastMsg);
                break;
            case 2:
                tv = findViewById(R.id.hi2);
                tv.setText(lastMsg);
                break;
            case 3:
                tv = findViewById(R.id.hi3);
                tv.setText(lastMsg);
                break;
            default:
                tv = findViewById(R.id.hi1);
                tv.setText("");
                tv = findViewById(R.id.hi2);
                tv.setText("");
                tv = findViewById(R.id.hi3);
                tv.setText("");
        }
    }

    // dock navigation methods
    public void toSearch(View view) {
        Intent intent = new Intent(this, Search.class);
        startActivity(intent);
    }

    public void toProfile(View view) {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }
}