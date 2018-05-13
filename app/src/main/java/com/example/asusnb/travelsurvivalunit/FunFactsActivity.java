package com.example.asusnb.travelsurvivalunit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FunFactsActivity extends AppCompatActivity {

    Collections c;
    TextView tw;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        tw = findViewById(R.id.fun_fact);
        tw.setMovementMethod(new ScrollingMovementMethod());

        c = new Collections (this, "traditions",
                "funfacts");
        tw.setText (c.getNextFunFact());

        iv = findViewById (R.id.favourite_button);
        if ( User.currentUser.inFavourites (c.getCurrentFunFact()) )
            iv.setImageResource (android.R.drawable.btn_star_big_on);
        else
            iv.setImageResource (android.R.drawable.btn_star_big_off);
    }

    public void backToMain (View view) {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity (intent);
    }

    public void nextFunFact (View view) {
        tw.setText (c.getNextFunFact());
        if ( User.currentUser.inFavourites (c.getCurrentFunFact()))
            iv.setImageResource (android.R.drawable.btn_star_big_on);
        else
            iv.setImageResource (android.R.drawable.btn_star_big_off);
    }

    public void toggleFavourite (View view) {
        if ( User.currentUser.inFavourites (c.getCurrentFunFact()) ) {
            iv.setImageResource(android.R.drawable.btn_star_big_off);
            System.out.println (User.currentUser.removeFromFavourites (c.getCurrentFunFact()));
        }

        else {
            User.currentUser.addToFavourites(c.getCurrentFunFact());
            iv.setImageResource(android.R.drawable.btn_star_big_on);
        }
    }
}
