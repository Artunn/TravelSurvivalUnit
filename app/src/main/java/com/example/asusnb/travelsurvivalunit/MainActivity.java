package com.example.asusnb.travelsurvivalunit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.activity_main);

        TextView tw;
        XMLMap map;
        HashMap<String, Double> hmap;

        tw = findViewById (R.id.name_surname_main);
        tw.setText (User.currentUser.name + " " + User.currentUser.surname);

        tw = findViewById (R.id.country_main);
        tw.setText (User.currentUser.homeCountry);

        tw = findViewById (R.id.trans_dir_main);
        tw.setText (User.currentUser.motherLanguage + " - " + User.currentUser.targetLanguage);

        tw.findViewById (R.id.city_main);
        tw.setText (User.currentUser.destination);

        map = new XMLMap();
        hmap = map.getMap();
        tw = findViewById (R.id.currency_top);
        tw.setText ("1 GBP = " + hmap.get("TRY") + " TRY");
        tw = findViewById (R.id.currency_bottom);
        tw.setText ("1 TRY = " + hmap.get("GBP") + " GBP");
        //System.out.println (hmap.containsKey("TRY"));
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