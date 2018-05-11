package com.example.asusnb.travelsurvivalunit;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity implements View.OnClickListener{

    EditText username;
    EditText email;
    EditText password;
    EditText passwordConfirm;
    Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        passwordConfirm = (EditText) findViewById(R.id.passwordConfirm);
        continueButton = (Button) findViewById(R.id.continueButton);
        continueButton.setOnClickListener(this);
     }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.continueButton:
                registrationX();
                System.out.println("SEA");
                break;

        }

    }

    public void registrationX(){
        if(username.getText().toString().matches("")){
            System.out.print("empty");
            Toast.makeText(this,"Please enter a e",Toast.LENGTH_LONG).show();
        }
        else if(email.getText().toString().matches("")){
            Toast.makeText(this,"Please enter a email",Toast.LENGTH_LONG).show();
        }
        else if(password.getText().toString().matches("")){
            Toast.makeText(this,"Please enter a password",Toast.LENGTH_LONG).show();
        }
        else if(passwordConfirm.getText().toString().matches("")){
            Toast.makeText(this,"Password Confirm line must be filled",Toast.LENGTH_LONG).show();
        }
        else if(!password.getText().toString().equals(passwordConfirm.getText().toString())){
            Toast.makeText(this,"Password and Confirm Passwords lines must match!",Toast.LENGTH_LONG).show();
        }
        else{
            Intent RegisterSecondScreen = new Intent(this, RegisterSecondScreen.class);
            //I WILL PASS DATA TO ANOTHER INTENT
            RegisterSecondScreen.putExtra("username",username.getText().toString() );
            RegisterSecondScreen.putExtra("email",email.getText().toString() );
            RegisterSecondScreen.putExtra("password",password.getText().toString() );

            //start next activity
            startActivity(RegisterSecondScreen);
        }
    }
}
