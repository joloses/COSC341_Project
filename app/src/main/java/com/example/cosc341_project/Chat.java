package com.example.cosc341_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Chat extends AppCompatActivity {

    // get views
    ArrayList<TextView> arr = new ArrayList<>();
    TextView tv;
    EditText et;
    int count = 0;

    ImageView img;
    TextView name;
    int img_id;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        // get name and image data
        Intent intent = getIntent();
        bundle = intent.getExtras();

        // set name and image
        img = findViewById(R.id.profilePic);
        img_id = bundle.getInt("img");
        setImg(img_id);
        name = findViewById(R.id.chatName);
        name.setText(bundle.getString("name"));

        // get views
        et = findViewById(R.id.enterText);
        arr.add(findViewById(R.id.tv1));
        arr.add(findViewById(R.id.tv2));
        arr.add(findViewById(R.id.tv3));
        arr.add(findViewById(R.id.tv4));
        arr.add(findViewById(R.id.tv5));
        arr.add(findViewById(R.id.tv6));
        arr.add(findViewById(R.id.tv7));
        arr.add(findViewById(R.id.tv8));
        arr.add(findViewById(R.id.tv9));
        arr.add(findViewById(R.id.tv10));
        tv = arr.get(count);
    }

    // set image with passed img_id
    public void setImg(int i) {
        switch (i) {
            case 1:
                img.setImageResource(R.drawable.rzhenie);
                break;
            case 2:
                img.setImageResource(R.drawable.profile_icon);
                break;
            case 3:
                img.setImageResource(R.drawable.beer);
                break;
        }
    }

    // "send" message
    public void send(View view) {
        String msg = et.getText().toString();
        if(msg.trim().length() == 0)
            return;
        if(count > 0)
            shift();
        tv.setText(msg);
        count++;
        et.setText("");
    }

    // move the text one textview up, so it seems like texting
    // looks ugly and needs a loop
    public void shift() {
        TextView t1 = arr.get(0);
        TextView t2 = arr.get(1);
        TextView t3 = arr.get(2);
        TextView t4 = arr.get(3);
        TextView t5 = arr.get(4);
        TextView t6 = arr.get(5);
        TextView t7 = arr.get(6);
        TextView t8 = arr.get(7);
        TextView t9 = arr.get(8);
        TextView t10 = arr.get(9);

        t10.setText(t9.getText().toString());
        t9.setText(t8.getText().toString());
        t8.setText(t7.getText().toString());
        t7.setText(t6.getText().toString());
        t6.setText(t5.getText().toString());
        t5.setText(t4.getText().toString());
        t4.setText(t3.getText().toString());
        t3.setText(t2.getText().toString());
        t2.setText(t1.getText().toString());
    }

    // back to chat_list
    public void back(View view) {
        Intent intent = new Intent();
        intent.putExtra("lastMsg", arr.get(0).getText().toString());
        intent.putExtra("i", Integer.toString(img_id));
        setResult(1, intent);
        finish();
    }

}