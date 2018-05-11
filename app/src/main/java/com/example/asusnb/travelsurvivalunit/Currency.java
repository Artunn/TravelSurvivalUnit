package com.example.asusnb.travelsurvivalunit;

public class Currency {
    //properties
    static XMLMap map;


    //constructors
    public Currency(){
        map = new XMLMap();
    }

    //methods
    public double convertGBPToTRY(){
        double gBPValue;
        double tRYValue;
        gBPValue = map.getMap().get("GBP");
        tRYValue = map.getMap().get("TRY");

        // calculation
        return tRYValue / gBPValue;
    }


}