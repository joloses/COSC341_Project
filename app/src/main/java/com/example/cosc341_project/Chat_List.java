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

    // need to get info about connections
    TextView empty;
    TextView test;
    LinearLayout block1;
    LinearLayout block2;
    LinearLayout block3;

    TextView name1;
    TextView name2;
    TextView name3;
    Global data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);

        data = Global.getInstance();
        test = findViewById(R.id.msg);

        block1 = findViewById(R.id.block1);
        block2 = findViewById(R.id.block2);
        block3 = findViewById(R.id.block3);

        name1 = findViewById(R.id.name1);
        name2 = findViewById(R.id.name2);
        name3 = findViewById(R.id.name3);

        empty = findViewById(R.id.emptyTV);
        if(data.empty())
            hideDialog();
        else {
            showDialog();
            hideText();
        }
    }

    public void showDialog() {
        aHideDialog();
        if(data.getOne() == 1)
            block1.setVisibility(View.VISIBLE);
        if(data.getTwo() == 1)
            block2.setVisibility(View.VISIBLE);
        if(data.getThree() == 1)
            block3.setVisibility(View.VISIBLE);
    }

    public void hideDialog() {
        block1.setVisibility(View.INVISIBLE);
        block2.setVisibility(View.INVISIBLE);
        block3.setVisibility(View.INVISIBLE);
    }

    public void aHideDialog() {
        block1.setVisibility(View.GONE);
        block2.setVisibility(View.GONE);
        block3.setVisibility(View.GONE);
    }

    public void hideText() {
        TextView aa = findViewById(R.id.emptyTV);
        aa.setVisibility(View.GONE);
    }

    public void openChat(View view) {
        Bundle extras = new Bundle();
        Intent intent = new Intent(this, Chat.class);

        switch (view.getId()) {
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

    public void toSearch(View view) {
        Intent intent = new Intent(this, Search.class);
        startActivity(intent);
    }

    // methods for dock buttons
    public void toProfile(View view) {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }
}