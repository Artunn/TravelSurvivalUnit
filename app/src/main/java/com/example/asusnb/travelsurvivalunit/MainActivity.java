package com.example.asusnb.travelsurvivalunit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        City cityToUse;
        User userToUse;
    }

    public void openSettings(View view) {
        Intent intent = new Intent( this, SettingsActivity.class);
        startActivity( intent);
    }

    public void openTraditions (View view) {
        Intent intent = new Intent (this, TraditionsActivity.class);
        startActivity (intent);
    }

    public void openTranslation (View view) {
        Intent intent = new Intent (this, CategoriesPage.class);
        startActivity (intent);
    }

    public void openFunFacts (View view) {
        Intent intent = new Intent (this, FunFactsActivity.class);
        startActivity (intent);
    }

    public void openFavourites (View view) {
        Intent intent = new Intent (this, MyFavouritesActivity.class);
        startActivity (intent);
    }
}