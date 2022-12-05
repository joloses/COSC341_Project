package com.example.cosc341_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Create_Acc_Screen4 extends AppCompatActivity {

    CheckBox sport1, sport2, sport3, sport4;
    EditText text1;
    Button nextButt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_acc_screen4);

        sport1 = findViewById(R.id.hockeyBox);
        sport2 = findViewById(R.id.basketballBox);
        sport3 = findViewById(R.id.baseballBox);
        sport4 = findViewById(R.id.soccerBox);
        text1 = findViewById(R.id.otherFillText);

        nextButt = findViewById(R.id.ca1_nxtbutt3);
        nextButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentProfile4 = new Intent(Create_Acc_Screen4.this, Create_Acc_Screen4.class);
                Bundle bundleProfile4 = new Bundle();

                if(sport1.isChecked() == true) {
                    String s1 = (sport1.getText().toString());
                    bundleProfile4.putString("sport1", s1);
                }
                if(sport2.isChecked() == true) {
                    String s2 = (sport2.getText().toString());
                    bundleProfile4.putString("sport2", s2);
                }
                if(sport3.isChecked() == true) {
                    String s3 = (sport3.getText().toString());
                    bundleProfile4.putString("sport3", s3);
                }
                if(sport4.isChecked() == true) {
                    String s4 = (sport4.getText().toString());
                    bundleProfile4.putString("sport4", s4);
                }

                String s5 = text1.getText().toString();
                bundleProfile4.putString("text1", s5);

                intentProfile4.putExtras(bundleProfile4);
                startActivity(intentProfile4);
            }
        });
    }
}