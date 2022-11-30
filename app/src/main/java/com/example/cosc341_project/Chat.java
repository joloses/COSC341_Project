package com.example.cosc341_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Chat extends AppCompatActivity {

    ArrayList<TextView> arr = new ArrayList<>();
    TextView tv;
    EditText et;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        et = findViewById(R.id.enterText);
        arr.add(findViewById(R.id.tv1));
        arr.add(findViewById(R.id.tv2));
        arr.add(findViewById(R.id.tv3));
        arr.add(findViewById(R.id.tv4));
        arr.add(findViewById(R.id.tv5));
        arr.add(findViewById(R.id.tv6));
        tv = arr.get(count);
    }

    public void send(View view) {
        String msg = et.getText().toString();
        if(count > 0)
            shift();
        tv.setText(msg);
        count++;
        et.setText("");
    }

    public void shift() {   // looks ugly and needs a loop
        TextView t1 = arr.get(0);
        TextView t2 = arr.get(1);
        TextView t3 = arr.get(2);
        TextView t4 = arr.get(3);
        TextView t5 = arr.get(4);
        TextView t6 = arr.get(5);

        t6.setText(t5.getText().toString());
        t5.setText(t4.getText().toString());
        t4.setText(t3.getText().toString());
        t3.setText(t2.getText().toString());
        t2.setText(t1.getText().toString());
    }

    public void toChat(View view) {
        finish();
    }

    // methods to jump to different views
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