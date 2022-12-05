package com.example.cosc341_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Chat extends AppCompatActivity {

    ArrayList<TextView> arr = new ArrayList<>();
    TextView tv;
    EditText et;
    int count = 0;

    ImageView img;
    TextView name;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        img = findViewById(R.id.profilePic);
        i = bundle.getInt("img");
        setImg(i);
        name = findViewById(R.id.chatName);
        name.setText(bundle.getString("name"));

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

    public void toChat(View view) {
        finish();
    }

    public void back(View view) {
        Intent intent = new Intent();
        intent.putExtra("lastMsg", arr.get(0).getText().toString());
        intent.putExtra("i", Integer.toString(i));
        setResult(1, intent);
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