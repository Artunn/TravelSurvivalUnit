package com.example.asusnb.travelsurvivalunit;

import java.io.Serializable;
import java.util.HashMap;

/**
 * __Currency class that uses the XMLParser to get the map and calculate currency rates___
 * @author __Ayşe Ezgi Yavuz___
 * @version __11.05.2018__
 */
public class Currency implements Serializable {
    //properties
    static XMLMap map;

    //constructors
    public Currency(){
        map = new XMLMap();
    }

    //methods
    /**
     * Calculate GTP to TRY rate and return
     * @return double
     */
    public double convertFromTo(HashMap<String, String> countries, String from, String to){
        double valueFrom;
        double valueTo;
        valueFrom = map.getMap().get( from);
        valueTo = map.getMap().get( to);

        // calculation
        return valueTo / valueFrom;
    }


}