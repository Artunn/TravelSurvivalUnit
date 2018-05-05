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

public class Login extends AppCompatActivity implements View.OnClickListener {
    EditText username;
    EditText password;
    CheckBox rememberMe;
    Button login;
    TextView createAnAccount;
    TextView resetPassword;
    TextView continueWithoutRegistration;
    FirebaseAuth auth;
    FirebaseUser user;
    ImageView backgroundTsu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();

        backgroundTsu = (ImageView) findViewById(R.id.backgroundTsu);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.passwordConfirm);
        rememberMe = (CheckBox) findViewById(R.id.rememberMe);
        login = (Button) findViewById(R.id.login);
        createAnAccount = (TextView) findViewById(R.id.createAnAccount);
        resetPassword = (TextView) findViewById(R.id.resetPassword);
        continueWithoutRegistration = (TextView) findViewById(R.id.continueWithoutRegistration);
        login.setOnClickListener(this);
        createAnAccount.setOnClickListener(this);
    }

    public void onClick(View v) {
        // Perform action on click
        switch(v.getId()) {
            case R.id.login:
                auth.signInWithEmailAndPassword(username.getText().toString(),password.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    user = auth.getCurrentUser();
                                    Toast.makeText(Login.this, user.getEmail().toString(),Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                break;
            case R.id.createAnAccount:
                Intent intent = new Intent(this, Register1.class);
                startActivity(intent);
                break;
        }
    }
}