package com.example.asusnb.travelsurvivalunit;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Collections {
    //properties
    static HashMap<String, String> countries;
    HashMap<String, String> cityTrad;
    HashMap<String, String> cityFF;
    static ArrayList<String> traditions;
    static ArrayList<String> funFacts;
    static int traditionNo = 1;
    static int funFactNo = 1;

    //constructor
    public Collections( Context context) {
        //Files need to be added
        countries = new HashMap<String, String>();
        countries.put("Turkey", "TRY");
        countries.put("England", "GBP");
        traditions = new ArrayList<String>();
        funFacts = new ArrayList<String>();
        cityFF = new HashMap<String, String>();

        try {
            InputStream inputStream = context.getAssets().open("traditions");
            Scanner scan = new Scanner(inputStream);
            while(scan.hasNextLine()) {
               traditions.add(scan.nextLine());
            }
        }
        catch ( IOException e) {
            e.printStackTrace();
        }
        try {
            InputStream inputStream = context.getAssets().open("funfacts");
            Scanner scan = new Scanner(inputStream);
            while(scan.hasNextLine()) {
                funFacts.add(scan.nextLine());
            }
        }
        catch ( IOException e) {
            e.printStackTrace();
        }
    }
        //methods
        public void addCountry(String countryName, String countryCurr){
            countries.put(countryName, countryCurr);
        }

        public String getCurrency (String country){
            return countries.get(country);
        }

        public String getNextTradition() {return traditions.get(traditionNo++);}
//    private void setFF(){
//        InputStream is = context.getAssets().open("subquestions");
//        Scanner scan = new Scanner( is);
//
//    }
}
