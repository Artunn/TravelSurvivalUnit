package com.example.asusnb.travelsurvivalunit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class MyFavouritesActivity extends AppCompatActivity {

    TextView ff1;
    TextView ff2;
    TextView ff3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_favourites);

        ff1 = findViewById(R.id.fun_fact_one);
        ff1.setMovementMethod(new ScrollingMovementMethod());

        ff2 = findViewById(R.id.fun_fact_two);
        ff2.setMovementMethod(new ScrollingMovementMethod());

        ff3 = findViewById(R.id.fun_fact_three);
        ff3.setMovementMethod(new ScrollingMovementMethod());

        ff1.setText (User.currentUser.favourites.get(0));
        ff2.setText (User.currentUser.favourites.get(1));
        ff3.setText (User.currentUser.favourites.get(2));
    }
}
