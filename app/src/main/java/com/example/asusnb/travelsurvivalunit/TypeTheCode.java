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

    String code;
    String mail;
    EditText codeInput;
    Button continueButton;
    Button resend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_the_code);
        code = getIntent().getExtras().getString("savecode",null);
        mail = getIntent().getExtras().getString("mail",null);
        codeInput = (EditText) findViewById(R.id.code);
        continueButton = (Button) findViewById(R.id.continueButton);
        resend = (Button) findViewById(R.id.button);
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
                else if(!codeInput.getText().toString().equals(code)){
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
        final ProgressDialog dialog = new ProgressDialog(TypeTheCode.this);
        dialog.setTitle("Sending Email");
        dialog.setMessage("Please wait");
        dialog.show();
        Thread sender = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    GMailSender sender = new GMailSender("travelsurvivalunitapp@gmail.com", "TsUnit123");
                    sender.sendMail("Reset Password",
                            code,
                            "travelsurvivalunitapp@gmail.com",
                            mail);
                    dialog.dismiss();
                } catch (Exception e) {
                    Log.e("mylog", "Error: " + e.getMessage());
                }
            }
        });
        sender.start();
    }
}
