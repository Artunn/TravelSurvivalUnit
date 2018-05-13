package com.example.asusnb.travelsurvivalunit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FavouritesActivity extends AppCompatActivity {

    ListView lw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);

        lw = findViewById(R.id.favourites);

        ArrayAdapter<String> arrayListAdapter = new ArrayAdapter<String> (this,
                R.layout.tsu_list_item, User.currentUser.favourites);

        lw.setAdapter(arrayListAdapter);
    }
}
