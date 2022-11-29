package com.example.cosc341_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Create_Acc_Screen1 extends AppCompatActivity {

    EditText fname;
    EditText lname;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_acc_screen);

        // first name entry box
        fname = findViewById(R.id.fname_filltxt);

        // last name entry box
        lname = findViewById(R.id.lname_filltxt);

        // on button click
        next = findViewById(R.id.ca1_nxtbutt);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check if first name has been entered
                if(fname.getText().toString().trim().length() < 1) {
                    String errMsg = "Please enter a first name";
                    Toast.makeText(Create_Acc_Screen1.this, errMsg, Toast.LENGTH_LONG).show();
                    // check if last name has been entered
                } else if(lname.getText().toString().trim().length() < 1){
                    String errMsg = "Please enter a last name";
                    Toast.makeText(Create_Acc_Screen1.this, errMsg, Toast.LENGTH_LONG).show();
                    // move on to the next screen
                } else {
                    Intent ca_intent = new Intent(Create_Acc_Screen1.this, Create_Acc_Screen2.class);
                    startActivity(ca_intent);
                }
            }
        });
    }
}