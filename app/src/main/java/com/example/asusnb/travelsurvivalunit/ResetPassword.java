package com.example.asusnb.travelsurvivalunit;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class ResetPassword extends AppCompatActivity implements View.OnClickListener {

    EditText typeMail;
    Button continueButton;
    UserDatabaseHelper db;
    private String saveCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        db = new UserDatabaseHelper(this);
        continueButton = (Button) findViewById(R.id.continueButton);
        typeMail = (EditText) findViewById(R.id.email);
        continueButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.continueButton){
            if(typeMail.getText().toString().matches("")){
                Toast.makeText(this,"Please type a mail!",Toast.LENGTH_LONG).show();
            }
            else if(!isNetworkConnected()){
                Toast.makeText(this,"Not online! Please try again later.", Toast.LENGTH_LONG).show();
            }
            else if(!db.usedMailTest(typeMail.getText().toString())){
                Toast.makeText(this,"This mail has not used yet!", Toast.LENGTH_LONG).show();
            }
            else{
                sendEmail();
            }
        }
    }

    protected void sendEmail() {
        Log.i("Send email", "");
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, typeMail.getText().toString());
        emailIntent.putExtra(Intent.EXTRA_CC, "Travel Survival Unit");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Password Reset");
        emailIntent.putExtra(Intent.EXTRA_TEXT, passwordResetCode());

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Successful", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }

    protected String passwordResetCode(){
        String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder code = new StringBuilder();
        Random rnd = new Random();
        while (code.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * CHARS.length());
            code.append(CHARS.charAt(index));
        }
        saveCode = code.toString();
        return "YOUR SAVE CODE IS "+saveCode;
    }
}
