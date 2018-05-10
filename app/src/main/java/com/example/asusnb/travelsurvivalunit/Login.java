package com.example.asusnb.travelsurvivalunit;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Arrays;

public class Login extends AppCompatActivity implements View.OnClickListener {
    EditText username, password;
    CheckBox rememberMe;
    Button login;
    TextView createAnAccount, resetPassword, continueWithoutRegistration;
    FirebaseAuth auth;
    FirebaseUser user;
    UserDatabaseHelper db;
    User guest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new UserDatabaseHelper(this);
        guest = new User("TSU","","","Guest","User","","","",this);
        auth = FirebaseAuth.getInstance();
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.passwordConfirm);
        rememberMe = (CheckBox) findViewById(R.id.rememberMe);
        login = (Button) findViewById(R.id.login);
        createAnAccount = (TextView) findViewById(R.id.createAnAccount);
        resetPassword = (TextView) findViewById(R.id.resetPassword);
        continueWithoutRegistration = (TextView) findViewById(R.id.continueWithoutRegistration);
        login.setOnClickListener(this);
        resetPassword.setOnClickListener(this);
        createAnAccount.setOnClickListener(this);
        continueWithoutRegistration.setOnClickListener(this);
    }

    public void onClick(View v) {
        // Perform action on click
        switch(v.getId()) {
            case R.id.login:
                if(username.getText().toString().matches("")){
                    Toast.makeText(this,"Please enter your username",Toast.LENGTH_LONG).show();
                }
                else if(password.getText().toString().matches("")){
                    Toast.makeText(this,"Please enter your password",Toast.LENGTH_LONG);
                }
                else {
                    /*
                    auth.signInWithEmailAndPassword(username.getText().toString(), password.getText().toString())
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        user = auth.getCurrentUser();
                                        Toast.makeText(Login.this, user.getEmail().toString(), Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                     */

                     if(db.usernameAndPasswordCheck(username.getText().toString(),password.getText().toString()))
                     {
                         Toast.makeText(this,"You successfully logged in "+ User.currentUser.getName(),Toast.LENGTH_SHORT).show();
                         Intent mainMenu = new Intent(this,MainActivity.class);
                         startActivity(mainMenu);
                     }
                     else{
                         Toast.makeText(this,"CHECK YOUR USERNAME AND PASSWORD",Toast.LENGTH_SHORT).show();
                     }
                }
                break;
            case R.id.createAnAccount:
                Intent register = new Intent(this, Register.class);
                startActivity(register);
                break;
            case R.id.continueWithoutRegistration:
                User.setCurrentUser(guest);
                Intent guestLogin = new Intent(this, MainActivity.class);
                startActivity(guestLogin);
                break;
            case R.id.resetPassword:
                Intent resetPass = new Intent(this, ResetPassword.class);
                startActivity(resetPass);
        }
    }
}