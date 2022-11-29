package com.example.cosc341_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;

public class Create_Acc_Screen2 extends AppCompatActivity {

    public EditText email;
    public EditText password;
    private EditText confirmPassword;
    private Button next;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_acc_screen2);

        // email entry box
        email = findViewById(R.id.email_filltxt);

        // password entry box
        password = findViewById(R.id.password1_filltxt);

        // password confirm entry box
        confirmPassword = findViewById(R.id.password2_filltxt);

        // next button
        next = findViewById(R.id.ca1_nxtbutt2);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().trim().length() < 1) {
                    String errMsg = "Please enter an email";
                    Toast.makeText(Create_Acc_Screen2.this, errMsg, Toast.LENGTH_LONG).show();
                    // check if last name has been entered
                } else if(password.getText().toString().trim().length() < 1){
                    String errMsg = "Please enter a password";
                    Toast.makeText(Create_Acc_Screen2.this, errMsg, Toast.LENGTH_LONG).show();
                    // check if birthdate has been entered
                } else if(confirmPassword.getText().toString().trim().length() < 1) {
                    String errMsg = "Please confirm your password";
                    Toast.makeText(Create_Acc_Screen2.this, errMsg, Toast.LENGTH_LONG).show();
                } else if(passwordConfirm() == false) {
                    String errMsg = "Please ensure your passwords match";
                    Toast.makeText(Create_Acc_Screen2.this, errMsg, Toast.LENGTH_LONG).show();
                    // move on to the next screen
                } else {
                    Intent ca_intent = new Intent(Create_Acc_Screen2.this, Create_Acc_Screen3.class);
                    startActivity(ca_intent);
                }
            }
        });
    }

    public boolean passwordConfirm(){

        Boolean temp = true;
        String pass1 = password.getText().toString();
        String pass2 = confirmPassword.getText().toString();

        if(!pass1.equals(pass2)){
            temp = false;
        }
        return temp;
    }
}