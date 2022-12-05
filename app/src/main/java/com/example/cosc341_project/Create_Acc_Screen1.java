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
    EditText age;
    Button next;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_acc_screen);

        // first name entry
        fname = findViewById(R.id.fname_filltxt);

        // last name entry
        lname = findViewById(R.id.lname_filltxt);

        // age entry
        age = findViewById(R.id.age_filltxt);


        next = findViewById(R.id.ca_nxtbutt);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fname.getText().toString().trim().length() < 1){
                    String errMsg = "Please enter a first name";
                    Toast.makeText(Create_Acc_Screen1.this, errMsg, Toast.LENGTH_LONG).show();
                }

                if(lname.getText().toString().trim().length() < 1){
                    String errMsg = "Please enter a last name";
                    Toast.makeText(Create_Acc_Screen1.this, errMsg, Toast.LENGTH_LONG).show();
                }

                if(age.getText().toString().trim().length() < 1){
                    String errMsg = "Please enter your age";
                    Toast.makeText(Create_Acc_Screen1.this, errMsg, Toast.LENGTH_LONG).show();
                }

                Intent nextPage1 = new Intent(Create_Acc_Screen1.this, Create_Acc_Screen2.class);
                startActivity(nextPage1);

                Intent intentProfile1 = new Intent(Create_Acc_Screen1.this, Create_Acc_Screen1.class);
                Bundle bundleProfile1 = new Bundle();

                bundleProfile1.putString("firstName", fname.getText().toString());
                bundleProfile1.putString("lastName", lname.getText().toString());
                bundleProfile1.putString("age", age.getText().toString());

                intentProfile1.putExtras(bundleProfile1);
            }
        });

    }
}