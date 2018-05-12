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
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    User artun;
    Button set;
    EditText nameText;
    EditText surnameText;
    EditText languageText;
    EditText destination;
    EditText homeCountry;
    EditText background;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        artun = new User("artunn", "1234", "bursa", "artun",
                "cura", "English", "Turkish", "Turkey",
                null,"MAIL");


        nameText = findViewById(R.id.nameEdit);
        surnameText = findViewById(R.id.surnameEdit);
        languageText = findViewById(R.id.languageEdit);
        homeCountry = findViewById(R.id.homeCountryEdit);
        background = findViewById(R.id.backgroundEdit);
        set = findViewById(R.id.button4);
        destination = findViewById(R.id.editText6);
        nameText.setText(artun.getName());
        surnameText.setText(artun.getSurname());
        languageText.setText(artun.getMotherLanguage());
        homeCountry.setText(artun.homeCountry);
    }
    public void optionTheme(View view) {
        String[] listItems = new String[] {"item1","item2"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.theme);
        builder.setSingleChoiceItems(listItems, -1,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void setUser(View view) {
        artun.setName(nameText.getText().toString());
        artun.setSurname(surnameText.getText().toString());
        artun.setMotherLanguage(languageText.getText().toString());
        artun.setHomeCountry(homeCountry.getText().toString());
        artun.setDestination(destination.getText().toString());
    }

    public void changeAvatarNext(View view) {
        ImageView imageView;
        int image;

        imageView = findViewById( R.id.avatarImage);
        image = artun.nextAvatar();
        imageView.setImageResource( image);
        artun.setAvatar( image);
    }
    public void changeAvatarPrevious(View view) {
        ImageView imageView;
        int image;

        imageView = findViewById( R.id.avatarImage);
        image = artun.previousAvatar();
        imageView.setImageResource( image);
        artun.setAvatar( image);
    }
    public void goBack(View view) {
        Intent intent;
        intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}