package com.example.asusnb.travelsurvivalunit;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

public class TraditionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traditions);

        TextView tw = findViewById(R.id.tradition);
        tw.setMovementMethod(new ScrollingMovementMethod());

        Context context;
        TextView tradNo = findViewById(R.id.tradition_order);
        tradNo.setText("1");
    }

    public void backToMain (View view) {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity (intent);
    }
}
