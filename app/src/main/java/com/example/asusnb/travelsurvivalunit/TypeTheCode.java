package com.example.asusnb.travelsurvivalunit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Type;

public class TypeTheCode extends AppCompatActivity implements View.OnClickListener {

    String codee;
    String mail;
    EditText codeInput;
    Button continueButton;
    Button resend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_the_code);

        codeInput = (EditText) findViewById(R.id.code);
        continueButton = (Button) findViewById(R.id.continueButton);
        resend = (Button) findViewById(R.id.resend);

        codee = getIntent().getExtras().getString("saveCode",(String)null);
        mail = getIntent().getExtras().getString("mail",(String)null);

        Toast.makeText(this,codee,Toast.LENGTH_LONG).show();

        resend.setOnClickListener(this);
        continueButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.continueButton:
                if(codeInput.getText().toString().matches("")){
                    Toast.makeText(this,"Please type the code you get!",Toast.LENGTH_SHORT).show();
                }
                else if(!codeInput.getText().toString().equals(codee)){
                    Toast.makeText(this,"Incorrect code!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this,"Successful!",Toast.LENGTH_SHORT).show();
                    Intent changePass = new Intent(this, ChangePassword.class);
                    changePass.putExtra("mail",mail);
                    startActivity(changePass);
                }
                break;
            case R.id.resend:
                sendEmail();
                break;

        }
    }

    protected void sendEmail() {
        final ProgressDialog dialog2 = new ProgressDialog(TypeTheCode.this);
        dialog2.setTitle("Sending Email");
        dialog2.setMessage("Please wait");
        dialog2.show();
        Thread sender = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    GMailSender sender = new GMailSender("travelsurvivalunitapp@gmail.com", "TsUnit123");
                    sender.sendMail("Reset Password",codee,
                            "travelsurvivalunitapp@gmail.com",
                            mail);
                    dialog2.dismiss();
                } catch (Exception e) {
                    Log.e("mylog", "Error: " + e.getMessage());
                }
            }
        });
        sender.start();
    }
}
