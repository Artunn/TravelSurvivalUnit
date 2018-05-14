package com.example.asusnb.travelsurvivalunit;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SettingsActivity extends AppCompatActivity {

    User user;
    Button set;
    EditText nameText;
    EditText surnameText;
    EditText languageText;
    EditText destination;
    EditText homeCountry;
    EditText background;
    String tempLanguage;
    ImageView avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        user = User.currentUser;


        nameText = findViewById(R.id.nameEdit);
        surnameText = findViewById(R.id.surnameEdit);
        languageText = findViewById(R.id.languageEdit);
        homeCountry = findViewById(R.id.homeCountryEdit);
        background = findViewById(R.id.backgroundEdit);
        set = findViewById(R.id.button4);
        destination = findViewById(R.id.destinationEdit);
        avatar = findViewById(R.id.avatarImage);

        nameText.setText(user.getName());
        surnameText.setText(user.getSurname());
        languageText.setText(user.getMotherLanguage());
        homeCountry.setText(user.homeCountry);
        destination.setText(user.destination);
        tempLanguage = languageText.getText().toString();
        avatar.setImageResource(user.getAvatar());
    }

    public void setUser(View view) {
        user.setName(nameText.getText().toString());
        user.setSurname(surnameText.getText().toString());
        if( languageText.getText().toString().toLowerCase().equals("english") ||
                languageText.getText().toString().toLowerCase().equals("türkçe")) {
            user.setMotherLanguage(languageText.getText().toString());
            tempLanguage = languageText.getText().toString();
        }
        else {
            languageText.setText(tempLanguage);
        }
        user.setHomeCountry(homeCountry.getText().toString());
        user.setDestination(destination.getText().toString());
    }

    public void changeAvatarNext(View view) {
        ImageView imageView;
        int image;

        imageView = findViewById( R.id.avatarImage);
        image = user.nextAvatar();
        imageView.setImageResource( image);
        user.setAvatar( image);
    }
    public void changeAvatarPrevious(View view) {
        ImageView imageView;
        int image;

        imageView = findViewById( R.id.avatarImage);
        image = user.previousAvatar();
        imageView.setImageResource( image);
        user.setAvatar( image);
    }
    public void goBack(View view) {
        Intent intent;
        intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}