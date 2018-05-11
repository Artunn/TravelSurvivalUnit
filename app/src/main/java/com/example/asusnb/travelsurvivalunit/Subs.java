package com.example.asusnb.travelsurvivalunit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Subs extends AppCompatActivity {
    ArrayList<SubQuestions> questions;
    ArrayList<String> hello;
    ArrayList<String> merhaba;
    ArrayAdapter<String> hellox;
    ListView listView;
    TranslationPower tr;
    int language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subs);

        Intent intent = getIntent();
        tr = (TranslationPower) intent.getSerializableExtra("category");

        questions = tr.getSubsx( 0);
        listView = findViewById( R.id.listOfSubs);

        hello = new ArrayList<>();
        merhaba = new ArrayList<>();
        for( SubQuestions x : questions) {
            hello.add( x.question[0]);
            merhaba.add(x.question[1]);
        }

        hellox = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1,
                new ArrayList<String>());
        hellox.addAll( hello);


        listView.setAdapter( hellox);
        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println( questions.get( position).question[0]);
                if( !questions.get(position).hasSpace && language == 0) {

                    hellox.clear();
                    for( int i = 0; i < position; i++) {
                        hellox.add( hello.get( i));
                    }
                    hellox.add( merhaba.get(position));
                    for( int i = position + 1; i < hello.size(); i++) {
                        hellox.add( hello.get( i));
                    }
                }
                if( !questions.get(position).hasSpace && language == 1) {

                    hellox.clear();
                    for( int i = 0; i < position; i++) {
                        hellox.add( merhaba.get( i));
                    }
                    hellox.add( hello.get(position));
                    for( int i = position + 1; i < merhaba.size(); i++) {
                        hellox.add( merhaba.get( i));
                    }
                }
            }
        });



    }

    public void changeLanguage(View view) {
        if(language == 0) {
            hellox.clear();
            hellox.addAll(merhaba);
            language = 1;
        }
        else if (language == 1) {
            hellox.clear();
            hellox.addAll(hello);
            language = 0;
        }
    }

}
