package com.example.asusnb.travelsurvivalunit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TraditionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traditions);
    }

    public void backToMain (View view) {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity (intent);
    }
}
