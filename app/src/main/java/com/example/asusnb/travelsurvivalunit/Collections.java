package com.example.asusnb.travelsurvivalunit;

import java.util.ArrayList;
import java.util.HashMap;

public class Collections {
    //properties
    static HashMap<String, String> countries;
    HashMap<String, String> cityTrad;
    HashMap<String, String> cityFF;
    ArrayList<String> traditions;
    ArrayList<String> funFacts;

    //constructor
    public Collections() {
        //Files need to be added
        countries = new HashMap<String, String>();
        countries.put("Turkey", "TRY");
        countries.put("England", "GBP");
        traditions = new ArrayList<String>();
        funFacts = new ArrayList<String>();
        cityFF = new HashMap<String, String>();
    }
        //methods
        public void addCountry(String countryName, String countryCurr){
            countries.put(countryName, countryCurr);
        }
        public String getCurrency (String country){
            return countries.get(country);
        }
//    private void setFF(){
//        InputStream is = context.getAssets().open("subquestions");
//        Scanner scan = new Scanner( is);
//
//    }
}
