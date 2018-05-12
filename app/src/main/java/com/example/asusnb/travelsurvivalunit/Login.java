package com.example.asusnb.travelsurvivalunit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity implements View.OnClickListener {
    EditText username, password;
    CheckBox rememberMe;
    Button login;
    TextView createAnAccount, resetPassword, continueWithoutRegistration;
    FirebaseAuth auth;
    FirebaseUser user;
    UserDatabaseHelper db;
    User guest;
    SharedPreferences rememberMeSP;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new UserDatabaseHelper(this);
        auth = FirebaseAuth.getInstance();
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.passwordConfirm);
        rememberMe = (CheckBox) findViewById(R.id.rememberMe);
        login = (Button) findViewById(R.id.login);
        createAnAccount = (TextView) findViewById(R.id.createAnAccount);
        resetPassword = (TextView) findViewById(R.id.resetPassword);
        continueWithoutRegistration = (TextView) findViewById(R.id.continueWithoutRegistration);
        rememberMeSP = this.getSharedPreferences("remember",this.MODE_PRIVATE);
        editor = rememberMeSP.edit();

        login.setOnClickListener(this);
        resetPassword.setOnClickListener(this);
        createAnAccount.setOnClickListener(this);
        continueWithoutRegistration.setOnClickListener(this);

        //If user has clicked rememberMe button on his/her previous login, username and password will be filled.
        preferencesTest();
        guest = new User("TSU","","","Guest","User","","","",this,"nomail@gmail.com");
    }

    public void onClick(View v) {
        // Perform action on click
        switch(v.getId()) {
            case R.id.login:
                if(username.getText().toString().matches("")){
                    Toast.makeText(this,"Please enter your username",Toast.LENGTH_LONG).show();
                    User sdfsd = new User("a","a","a","a","a","a","a","a",this  ,"a");
                    db.insertData(sdfsd);
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
                        rememberMeCheck();
                        Intent mainMenu = new Intent(this,MainActivity.class);
                        startActivity(mainMenu);
                    }
                    else{
                        Toast.makeText(this,"Please check your username and password",Toast.LENGTH_SHORT).show();
                        password.getText().clear();
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

    public void rememberMeCheck(){
        if(rememberMe.isChecked()){
            editor.putString("username",username.getText().toString());
            System.out.println("remembermecheck username set as" + username.getText().toString());
            editor.putString("password",password.getText().toString());
            System.out.println("remembermecheck pass set as" + password.getText().toString());
            editor.apply();
        }
        else{
            editor.putString("username","");
            System.out.println("remembermecheck username set as empty");
            editor.putString("password","");
            System.out.println("remembermecheck pass set as empty");
            editor.apply();
        }
    }

    public void preferencesTest(){
        String us = rememberMeSP.getString("username","");
        System.out.println("preferencesTest username " + us);
        String pa = rememberMeSP.getString("password","");
        System.out.println("preferencesTest password " + us);
        if(!us.equals("")){
            username.setText(us);
            password.setText(pa);
            rememberMe.setChecked(true);
        }
    }
}