package com.example.asusnb.travelsurvivalunit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TraditionsActivity extends AppCompatActivity {

    Collections c;
    TextView tw;
    TextView to;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traditions);

        tw = findViewById(R.id.tradition);
        tw.setMovementMethod(new ScrollingMovementMethod());

        c = new Collections (this, "traditions",
                "funfacts");
        tw.setText (c.getNextTradition());
        to = findViewById (R.id.tradition_order_display);
        to.setText (c.traditionNo + "");

        iv = findViewById (R.id.favourite_button);
        if ( User.currentUser.inFavourites (c.getCurrentTradition()) )
            iv.setImageResource (android.R.drawable.btn_star_big_on);
        else
            iv.setImageResource (android.R.drawable.btn_star_big_off);
    }

    public void backToMain (View view) {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity (intent);
    }

    public void nextTradition (View view) {
        tw.setText (c.getNextTradition());
        to.setText (c.traditionNo + "");
        if ( User.currentUser.inFavourites (c.getCurrentTradition()))
            iv.setImageResource (android.R.drawable.btn_star_big_on);
        else
            iv.setImageResource (android.R.drawable.btn_star_big_off);
    }

    public void toggleFavourite (View view) {
        if ( User.currentUser.inFavourites (c.getCurrentTradition()) ) {
            iv.setImageResource(android.R.drawable.btn_star_big_off);
            System.out.println (User.currentUser.removeFromFavourites (c.getCurrentTradition()));
        }

        else {
            User.currentUser.addToFavourites(c.getCurrentTradition());
            iv.setImageResource(android.R.drawable.btn_star_big_on);
        }
    }
}
