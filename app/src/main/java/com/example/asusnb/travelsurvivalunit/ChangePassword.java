package com.example.asusnb.travelsurvivalunit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePassword extends AppCompatActivity implements View.OnClickListener{
    EditText newPass1;
    EditText newPass2;
    Button resetPass;
    String mail;
    UserDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        newPass1 = (EditText) findViewById(R.id.password);
        newPass2 = (EditText) findViewById(R.id.passwordConfirm);
        resetPass = (Button) findViewById(R.id.resetpassword);

        db = new UserDatabaseHelper(this);
        mail = getIntent().getExtras().getString("mail",null);

        resetPass.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.resetpassword){
            if(newPass1.getText().toString().matches("")){
                Toast.makeText(this,"First line is empty!",Toast.LENGTH_SHORT).show();
            }
            else if(newPass1.getText().toString().length() < 6){
                Toast.makeText(this,"Passwords must be at least 6 characters long!",Toast.LENGTH_SHORT).show();
            }
            else if(!newPass1.getText().toString().equals(newPass2.getText().toString())) {
                Toast.makeText(this, "Passwords dont match!", Toast.LENGTH_SHORT).show();
            }
            else{
                if(db.changePassword(mail,newPass1.getText().toString())){
                    Toast.makeText(this,"SUCCESSFUL",Toast.LENGTH_SHORT).show();
                    Intent login = new Intent(ChangePassword.this, Login.class);
                    startActivity(login);
                }
                else{
                    Toast.makeText(this,"ERROR",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
