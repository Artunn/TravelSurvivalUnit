package com.example.asusnb.travelsurvivalunit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class CategoriesPage extends AppCompatActivity {

    Button transportationButton;
    Button accommodationButton;
    Button restaurantButton;
    Button shoppingButton;
    Button dailyButton;
    Button emergencyButton;
    Intent intent;
    TranslationPower translationPow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_page);

        transportationButton = findViewById( R.id.transportation);
        accommodationButton = findViewById( R.id.accommodation);
        restaurantButton = findViewById( R.id.restaurant);
        shoppingButton = findViewById( R.id.shopping);
        dailyButton = findViewById( R.id.daily);
        emergencyButton = findViewById( R.id.emergency);

        transportationButton.setText( UniversalData.CATEGORIES[0][0]);
        accommodationButton.setText( UniversalData.CATEGORIES[1][0]);
        restaurantButton.setText( UniversalData.CATEGORIES[2][0]);
        shoppingButton.setText( UniversalData.CATEGORIES[3][0]);
        dailyButton.setText( UniversalData.CATEGORIES[4][0]);
        emergencyButton.setText( UniversalData.CATEGORIES[5][0]);

        translationPow = new TranslationPower( this);

        intent = new Intent( this, Subs.class);
        intent.putExtra( "category", translationPow);
    }

    public void c1(View view) {

        intent.putExtra("categoryNum",0);
        startActivity( intent);
    }
    public void c2(View view) {

        intent.putExtra("categoryNum",1);
        startActivity( intent);
    }
    public void c3(View view) {

        intent.putExtra("categoryNum",2);
        startActivity( intent);

    }
    public void c4(View view) {

        intent.putExtra("categoryNum",3);
        startActivity( intent);

    }
    public void c5(View view) {

        intent.putExtra("categoryNum",4);
        startActivity( intent);

    }
    public void c6(View view) {

        intent.putExtra("categoryNum",5);
        startActivity( intent);

    }



}
