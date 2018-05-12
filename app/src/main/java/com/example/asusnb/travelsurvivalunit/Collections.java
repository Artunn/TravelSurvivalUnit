package com.example.asusnb.travelsurvivalunit;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Collections implements Serializable {
    //properties
    static HashMap<String, String> countries;
    HashMap<String, String> cityTrad;
    HashMap<String, String> cityFF;
    ArrayList<String> traditions;
    ArrayList<String> funFacts;
    int traditionNo;
    int funFactNo;
    String funFactsFileName;
    String traditionsFileName;

    //constructor
    public Collections( Context context, String traditionsFileName, String funFactsFileName ) {
        //Files need to be added
        countries = new HashMap<String, String>();
        countries.put("Turkey", "TRY");
        countries.put("England", "GBP");
        traditions = new ArrayList<String>();
        funFacts = new ArrayList<String>();
        cityFF = new HashMap<String, String>();
        traditionNo = 0;
        funFactNo = 0;
        this.traditionsFileName = traditionsFileName;
        this.funFactsFileName = funFactsFileName;

        try {
            InputStream inputStream = context.getAssets().open(traditionsFileName);
            Scanner scan = new Scanner(inputStream);
            while(scan.hasNextLine()) {
               traditions.add(scan.nextLine());
            }
        }
        catch ( IOException e) {
            e.printStackTrace();
        }
        try {
            InputStream inputStream = context.getAssets().open( funFactsFileName );
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

        public String getNextFunFact()
        {
            funFactNo++;
            return funFacts.get( funFactNo );
        }

        public String getNextTradition()
        {
            traditionNo++;
            return traditions.get(traditionNo);
        }

        public String getCurrentTradition() { return traditions.get( traditionNo ); }

        public String getCurrentFunFact() { return funFacts.get( funFactNo ); }


}
