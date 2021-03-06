package com.example.asusnb.travelsurvivalunit;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class RegisterSecondScreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    Spinner language, homeCountry;
    EditText name, surname;
    String username, password, email, languageStr, homeCountryStr, nameStr, surnameStr;
    Button register;
    UserDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_second_screen);

        db = new UserDatabaseHelper(this);
        language = findViewById(R.id.language);
        homeCountry = findViewById(R.id.homeCountry);
        homeCountry.setOnItemSelectedListener(this);
        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        register = findViewById(R.id.register);
        register.setOnClickListener(this);
        username = getIntent().getExtras().getString("username",(String) null);
        password = getIntent().getExtras().getString("password",(String) null);
        email = getIntent().getExtras().getString("email",null);
        ArrayAdapter<CharSequence> languageAdapter = ArrayAdapter.createFromResource(this,
                R.array.language_array, android.R.layout.simple_spinner_item);
        languageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        language.setAdapter(languageAdapter);


        ArrayAdapter<CharSequence> countryAdapter = ArrayAdapter.createFromResource(this,
                R.array.country_array, android.R.layout.simple_spinner_item);
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        homeCountry.setAdapter(countryAdapter);

        homeCountry.setOnItemSelectedListener(this);
        language.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.language:
                languageStr = language.getSelectedItem().toString();
                System.out.println(languageStr + "x");
                break;

            case R.id.homeCountry:
                homeCountryStr = homeCountry.getSelectedItem().toString();
                break;
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        languageStr = language.getItemAtPosition(0).toString();
        homeCountryStr = homeCountry.getItemAtPosition(0).toString();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register:
                if(name.getText().toString().matches("")){
                    Toast.makeText(this,"Please type your name",Toast.LENGTH_LONG).show();
                }
                else if(surname.getText().toString().matches("")){
                    Toast.makeText(this, "Please type your surname", Toast.LENGTH_LONG).show();
                }
                else{
                    nameStr = name.getText().toString();
                    surnameStr = surname.getText().toString();
                    String targetLanguage = demoTargetLanguage();
                    String destination = demoDestination();
                    User newUser = new User(username,password,homeCountryStr,nameStr,surnameStr,languageStr,targetLanguage,destination,this,email);
                    System.out.print(newUser.getName());
                    db.insertData(newUser);
                    Intent login = new Intent(this, Login.class);
                    startActivity(login);
                }
                break;
        }
    }

    public String demoTargetLanguage(){
        System.out.println(languageStr + " X ");
        if(languageStr.matches("türkçe")){
            return "english";
        }
        else{
            return "türkçe";
        }
    }
    public String demoDestination(){
        if(homeCountryStr.matches("türkiye")){
            return "london";
        }
        else{
            return "istanbul";
        }
    }
}
