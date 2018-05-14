package com.example.asusnb.travelsurvivalunit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.activity_main);

        TextView tw1;
        TextView tw2;
        TextView tw3;
        TextView tw4;
        TextView twCurT;
        TextView twCurB;

        ImageView iv;
        XMLMap map;
        HashMap<String, Double> hmap;

        tw1 = findViewById (R.id.name_surname_main);
        tw1.setText (User.currentUser.name + " " + User.currentUser.surname);

        tw2 = findViewById (R.id.country_main);
        tw2.setText (User.currentUser.homeCountry);

        tw3 = findViewById (R.id.trans_dir_main);
        tw3.setText (User.currentUser.motherLanguage + " - " + User.currentUser.targetLanguage);

        tw4 = findViewById (R.id.city_main);
        tw4.setText (User.currentUser.destination);

        iv = findViewById (R.id.avatar);
        iv.setImageResource (User.currentUser.getAvatar());

        map = new XMLMap();

        twCurT = findViewById (R.id.currency_top);
        twCurT.setText ("1 GBP = " + "5.84892" + " TRY");
        twCurB = findViewById (R.id.currency_bottom);
        twCurB.setText ("1 TRY = " + "0.170972" + " GBP");
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
        Intent intent = new Intent (this, FavouritesActivity.class);
        startActivity (intent);
    }
    public void openWorldClocks (View view) {
        Intent intent = new Intent (this, WorldClocks.class);
        startActivity (intent);
    }
}