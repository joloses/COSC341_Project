package com.example.cosc341_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

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

                Intent ca_intent = new Intent(Create_Acc_Screen3.this, Create_Acc_Screen4.class);
                Bundle bundle = new Bundle();

                if(pro1.isChecked() == true) {
                    String s1 = (pro1.getText().toString());
                    bundle.putString("pro1", s1);
                } else if(pro2.isChecked() == true) {
                    String s2 = (pro2.getText().toString());
                    bundle.putString("pro2", s2);
                } else if(pro3.isChecked() == true) {
                    String s3 = (pro3.getText().toString());
                    bundle.putString("pro3", s3);
                } else if(pro4.isChecked() == true) {
                    String s4 = (pro4.getText().toString());
                    bundle.putString("pro4", s4);
                } else if(pro5.isChecked() == true) {
                    String s5 = (pro5.getText().toString());
                    bundle.putString("pro5", s5);
                }

                ca_intent.putExtras(bundle);
                startActivity(ca_intent);
            }
        });
    }
}


