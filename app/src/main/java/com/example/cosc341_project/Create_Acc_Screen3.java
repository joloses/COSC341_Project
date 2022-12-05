package com.example.cosc341_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Create_Acc_Screen3 extends AppCompatActivity {

    RadioButton pro1, pro2, pro3, pro4, pro5;
    Button nextButt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_acc_screen3);

        pro1 = findViewById(R.id.radButt1);
        pro2 = findViewById(R.id.radButt2);
        pro3 = findViewById(R.id.radButt3);
        pro4 = findViewById(R.id.radButt4);
        pro5 = findViewById(R.id.radButt5);

        nextButt = findViewById(R.id.ca1_nxtbutt3);
        nextButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent nextPage3 = new Intent(Create_Acc_Screen3.this, Create_Acc_Screen4.class);

                Intent intentProfile3 = new Intent(Create_Acc_Screen3.this, Create_Acc_Screen4.class);
                Bundle bundleProfile3 = new Bundle();

                if(pro1.isChecked() == true) {
                    String s1 = (pro1.getText().toString());
                    bundleProfile3.putString("choice1", s1);
                    startActivity(nextPage3);
                    intentProfile3.putExtras(bundleProfile3);
                } else if(pro2.isChecked() == true) {
                    String s2 = (pro2.getText().toString());
                    bundleProfile3.putString("choice2", s2);
                    startActivity(nextPage3);
                    intentProfile3.putExtras(bundleProfile3);
                } else if(pro3.isChecked() == true) {
                    String s3 = (pro3.getText().toString());
                    bundleProfile3.putString("choice3", s3);
                    startActivity(nextPage3);
                    intentProfile3.putExtras(bundleProfile3);
                } else if(pro4.isChecked() == true) {
                    String s4 = (pro4.getText().toString());
                    bundleProfile3.putString("choice4", s4);
                    startActivity(nextPage3);
                    intentProfile3.putExtras(bundleProfile3);
                } else if(pro5.isChecked() == true) {
                    String s5 = (pro5.getText().toString());
                    bundleProfile3.putString("choice5", s5);
                    startActivity(nextPage3);
                    intentProfile3.putExtras(bundleProfile3);
                } else {
                    String err = "Please choose an option";
                    Toast.makeText(Create_Acc_Screen3.this, err, Toast.LENGTH_LONG).show();

                }

            }
        });
    }
}


