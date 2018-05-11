package com.example.asusnb.travelsurvivalunit;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.util.Random;

public class ResetPassword extends AppCompatActivity implements View.OnClickListener {

    EditText typeMail;
    Button continueButton;
    UserDatabaseHelper db;
    String saveCode;

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
                Intent typeCode = new Intent(this, TypeTheCode.class);
                typeCode.putExtra("savecode",saveCode);
                typeCode.putExtra("mail",typeMail.getText().toString());
                startActivity(typeCode);
            }
        }
    }

    protected void sendEmail() {
        final ProgressDialog dialog = new ProgressDialog(ResetPassword.this);
        dialog.setTitle("Sending Email");
        dialog.setMessage("Please wait");
        dialog.show();
        Thread sender = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    GMailSender sender = new GMailSender("travelsurvivalunitapp@gmail.com", "TsUnit123");
                    sender.sendMail("Reset Password",
                            passwordResetCode(),
                            "travelsurvivalunitapp@gmail.com",
                            typeMail.getText().toString());
                    dialog.dismiss();
                } catch (Exception e) {
                    Log.e("mylog", "Error: " + e.getMessage());
                }
            }
        });
        sender.start();
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
        return "Your save code for your favorite app is "+saveCode + " . Have a nice day!";
    }

}
