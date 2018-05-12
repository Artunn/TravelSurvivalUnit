package com.example.asusnb.travelsurvivalunit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class SubWithSpace extends AppCompatActivity {

    String english;
    String turkish;
    String space;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_with_space);

        Intent intent = getIntent();
        english = intent.getStringExtra("eng");
        turkish = intent.getStringExtra("tr");
        space = intent.getStringExtra( "spaceVal");

        TextView tv = findViewById( R.id.textView9);
        tv.setText( english + "\n" + turkish);
        ListView listView;
        listView = findViewById( R.id.listView);

        ArrayList<String> listViewArrayList = new ArrayList<>();
        try {
            System.out.println(space);
            InputStream is = getAssets().open( space);
            Scanner scan = new Scanner(is);
            String nextLine;
            String[] questionInBothLanguages;
            while (scan.hasNextLine()) {
                nextLine = scan.nextLine();
                questionInBothLanguages = nextLine.split(":");
                listViewArrayList.add( questionInBothLanguages[0] + "\n" +
                        questionInBothLanguages[1]);
            }
            ArrayAdapter<String> x = new ArrayAdapter<>( this,
                    android.R.layout.simple_list_item_1,
                    listViewArrayList);
            listView.setAdapter(x);
        }
        catch ( IOException e) {
            e.printStackTrace();
        }
    }
}
