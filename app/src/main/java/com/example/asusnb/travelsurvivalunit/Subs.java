package com.example.asusnb.travelsurvivalunit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Subs extends AppCompatActivity {
    ArrayList<SubQuestion> questions;
    ArrayList<String> subQuestionsInFirstLanguage;
    ArrayList<String> getSubQuestionsInSecondLanguage;
    ArrayAdapter<String> stringAdapter;
    ListView listView;
    TranslationHelper translationHelper;
    int language;
    int selectedCategory;
    Intent nextPageIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subs);

        final Intent intent = getIntent();
        translationHelper = (TranslationHelper) intent.getSerializableExtra("category");
        selectedCategory = intent.getIntExtra("categoryNum", 0);
        questions = translationHelper.getSubsFromHelper( selectedCategory);
        listView = findViewById( R.id.listOfSubs);

        subQuestionsInFirstLanguage = new ArrayList<>();
        getSubQuestionsInSecondLanguage = new ArrayList<>();
        for( SubQuestion x : questions) {
            subQuestionsInFirstLanguage.add( x.question[0]);
            getSubQuestionsInSecondLanguage.add(x.question[1]);
        }

        stringAdapter = new ArrayAdapter<>( this, R.layout.tsu_list_item,
                new ArrayList<String>());
        stringAdapter.addAll( subQuestionsInFirstLanguage);


        listView.setAdapter( stringAdapter);
        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println( questions.get( position).question[0]);
                if( questions.get(position).space.equals("null") && language == 0) {

                    stringAdapter.clear();
                    for( int i = 0; i < position; i++) {
                        stringAdapter.add( subQuestionsInFirstLanguage.get( i));
                    }
                    stringAdapter.add( getSubQuestionsInSecondLanguage.get(position));
                    for( int i = position + 1; i < subQuestionsInFirstLanguage.size(); i++) {
                        stringAdapter.add( subQuestionsInFirstLanguage.get( i));
                    }
                }
                else if( questions.get(position).space.equals("null") && language == 1) {

                    stringAdapter.clear();
                    for( int i = 0; i < position; i++) {
                        stringAdapter.add( getSubQuestionsInSecondLanguage.get( i));
                    }
                    stringAdapter.add( subQuestionsInFirstLanguage.get(position));
                    for( int i = position + 1; i < getSubQuestionsInSecondLanguage.size(); i++) {
                        stringAdapter.add( getSubQuestionsInSecondLanguage.get( i));
                    }
                }
                else {
                    openQuestion( view);
                    nextPageIntent.putExtra("eng", questions.get(position).question[0]);
                    nextPageIntent.putExtra( "tr", questions.get(position).question[1]);
                    nextPageIntent.putExtra( "spaceVal", questions.get(position).space);
                    startActivity(nextPageIntent);
                }
            }
        });



    }

    public void openQuestion( View view) {
        nextPageIntent = new Intent( this,
                SubWithSpace.class);
    }

    public void changeLanguage(View view) {
        if(language == 0) {
            stringAdapter.clear();
            stringAdapter.addAll(getSubQuestionsInSecondLanguage);
            language = 1;
        }
        else if (language == 1) {
            stringAdapter.clear();
            stringAdapter.addAll(subQuestionsInFirstLanguage);
            language = 0;
        }
    }

}
