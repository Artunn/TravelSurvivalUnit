package com.example.asusnb.travelsurvivalunit;

import android.graphics.YuvImage;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register1 extends AppCompatActivity implements View.OnClickListener{

    EditText username;
    EditText email;
    EditText password;
    EditText passwordConfirm;
    Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);

        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        passwordConfirm = (EditText) findViewById(R.id.passwordConfirm);
        continueButton = (Button) findViewById(R.id.continueButton);
        continueButton.setOnClickListener(this);
     }


    @Override
    public void onClick(View v) {
        Toast.makeText(this,"Please enter a username",Toast.LENGTH_LONG).show();
        switch (v.getId()){
            case R.id.continueButton:
                registrationX();
                break;
        }
    }

    public void registrationX(){

        Toast.makeText(this,"Please enter a username",Toast.LENGTH_LONG);
        if(TextUtils.isEmpty(username.getText().toString().trim())){
            Toast.makeText(this,"Please enter a username",Toast.LENGTH_LONG);
        }
        if(TextUtils.isEmpty(email.getText().toString().trim())){
            Toast.makeText(this,"Please enter a email",Toast.LENGTH_LONG);
        }
        if(TextUtils.isEmpty(password.getText().toString().trim())){
            Toast.makeText(this,"Please enter a password",Toast.LENGTH_LONG);
        }
        if(TextUtils.isEmpty(passwordConfirm.getText().toString().trim())){
            Toast.makeText(this,"Password Confirm line must be filled",Toast.LENGTH_LONG);
        }
        if(!password.getText().equals(passwordConfirm.getText().toString().trim())){
            Toast.makeText(this,"Password and Confirm Passwords lines must match!",Toast.LENGTH_LONG);
        }
    }
}
