package com.example.asusnb.travelsurvivalunit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class CategoriesPage extends AppCompatActivity {

    Button c1;
    Button c2;
    Button c3;
    Button c4;
    Button c5;
    Button c6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_page);

        c1 = findViewById( R.id.c1);
        c2 = findViewById( R.id.c2);
        c3 = findViewById( R.id.c3);
        c4 = findViewById( R.id.c4);
        c5 = findViewById( R.id.c5);
        c6 = findViewById( R.id.c6);

        c1.setText( UniversalData.CATEGORIES[0][0]);
        c2.setText( UniversalData.CATEGORIES[0][1]);
        c3.setText( UniversalData.CATEGORIES[0][2]);
        c4.setText( UniversalData.CATEGORIES[0][3]);
        c5.setText( UniversalData.CATEGORIES[0][4]);
        c6.setText( UniversalData.CATEGORIES[0][5]);

    }



}
