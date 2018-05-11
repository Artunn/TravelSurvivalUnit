package com.example.asusnb.travelsurvivalunit;

import android.media.Image;

import java.util.GregorianCalendar;
import java.util.TimeZone;

public class City{
    // properties
    final int[] cityBackgrounds = {};
    String cityName;
    String country;
    //Collections tradAndFF;
    //AudioTrack music;
    Currency cityCurrency;
    double currencyRate;
    GregorianCalendar lastRetrieved;
    int background;
    Image weather;
    Integer backgroundId;
    int count;

    // constructors

    public City( String cityName){
    this.cityName = cityName;
    lastRetrieved = new GregorianCalendar( TimeZone.getTimeZone( cityName));
    //this.tradAndFF = tradAndFF;
    //this.music = music;
    cityCurrency = new Currency();
    backgroundId = cityBackgrounds[count];
    count = 0;
    updateAllData();
    }

    // methods
    public int[] updateAllData() {
        updateWeather( weather);
        updateRate();
        return updateLastRetrieved();
    }
    public void setBackgroundId(Integer backgroundId) {
        this.backgroundId = backgroundId;
    }
    private void updateWeather( Image weather) {
        this.weather = weather;
    }
    private void updateRate(){
        currencyRate = cityCurrency.convertGBPToTRY();
    }
    private int[] updateLastRetrieved(){
        int [] lastRetrievedArray;
        lastRetrievedArray = new int[ 5];
        lastRetrievedArray[0] = lastRetrieved.get( lastRetrieved.DAY_OF_MONTH);
        lastRetrievedArray[1] = lastRetrieved.get( lastRetrieved.MONTH);
        lastRetrievedArray[2] = lastRetrieved.get( lastRetrieved.YEAR);
        lastRetrievedArray[3] = lastRetrieved.get( lastRetrieved.HOUR_OF_DAY);
        lastRetrievedArray[4] = lastRetrieved.get( lastRetrieved.MINUTE);
        return lastRetrievedArray;
    }
}
