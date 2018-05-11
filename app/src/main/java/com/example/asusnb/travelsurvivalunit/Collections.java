package com.example.asusnb.travelsurvivalunit;

import java.util.HashMap;

public class Collections {
    //properties
    HashMap<String, String> countries;

    //constructor
    public Collections(){
        countries = new HashMap<String, String>();
        countries.put("Turkey", "TRY");
        countries.put("London", "GBP");
    }

    //methods
    public void addCountry( String countryName, String countryCurr){
        countries.put( countryName, countryCurr);
    }
    public String getCurrency( String country){
        return countries.get( country);
    }
}
