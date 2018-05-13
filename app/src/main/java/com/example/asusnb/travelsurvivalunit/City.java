package com.example.asusnb.travelsurvivalunit;

import android.content.Context;
import android.media.Image;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.TimeZone;
/**
 * __City class that defines the city packs and all the properties in the app___
 * @author __Ayşe Ezgi Yavuz___
 * @version __11.05.2018__
 */
public class City implements Serializable {
    // properties
    final int[] cityBackgrounds = {}; //Add background pic
    Image weather; //??
    String cityName;
    String country;
    Collections tradFFAncCurrency;
    Currency cityCurrency;
    double currencyRate;
    GregorianCalendar lastRetrieved;
    int background;
    Integer backgroundId;
    int count;
    //AudioTrack music;

    // constructors
    public City (String cityName, String country, String destination, Context context){
        this.cityName = cityName;
        this.country = country;
        lastRetrieved = new GregorianCalendar( TimeZone.getTimeZone( cityName));
        tradFFAncCurrency = new Collections( context,"","");
        //this.music = music;
        cityCurrency = new Currency();
        count = 0;
        backgroundId = cityBackgrounds[count];
        updateAllData( destination);
    }

    public City (String cityName, String country) {
        this.cityName = cityName;
        this.country = country;
        lastRetrieved = new GregorianCalendar( TimeZone.getTimeZone( cityName));
        //tradFFAncCurrency = new Collections( cityName, country, destination);
        //this.music = music;
        cityCurrency = new Currency();
        count = 0;
        backgroundId = cityBackgrounds[count];
    }

    // methods
    /**
     * Uses the private methods to update all the data
     * @return int[]
     */
    public int[] updateAllData( String destination) {
        updateWeather( weather);
        updateRate( destination);
        return updateLastRetrieved();
    }
    /**
     * Setter for background
     * @param backgroundId int[]
     */
    public void setBackgroundId(Integer backgroundId) {
        this.backgroundId = backgroundId;
    }
    /**
     * Sets avatar to  next image
     * @return backgroundId int
     */
    public int nextBackground()
    {
        if ( count < cityBackgrounds.length - 1 )
            count++;
        else
            count = 0;
        backgroundId = cityBackgrounds[count];

        return backgroundId;
    }

    /**
     * Sets avatar to previous image
     * @return backgroundId int
     */
    public int previousBackground()
    {
        if ( count > 0 )
            count--;
        else
            count = cityBackgrounds.length - 1;
        backgroundId = cityBackgrounds[count];

        return backgroundId;
    }

    /**
     * Gets the backgroundId
     * @return backgroundId int
     */
    public Integer getBackground()
    {
        return backgroundId;
    }

    /**
     * Sets background to background with the given backgroundId
     * @param backgroundId int
     */
    public void setBackground(Integer backgroundId)
    {
        this.backgroundId = backgroundId;
    }

    /**
     * Gets count for the background
     * @return count int
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets count to given count
     * @param count int
     */
    public void setCount( int count )
    {
        this.count = count;
    }
    /**
     * Increases count for background
     */
    public void increaseCount()
    {
        count++;
    }

    /**
     * Decrease count for background
     */
    public void decreaseCount()
    {
        count--;
    }
    public String getCountry() { return country; }
    private void updateWeather( Image weather) {
        this.weather = weather;
    }

    /**
     * Updates the conversion rate of the currency
     * @param destination String
     */
    private void updateRate( String destination){
        currencyRate = cityCurrency.convertFromTo( tradFFAncCurrency.countries, tradFFAncCurrency.getCurrency( country),
                tradFFAncCurrency.getCurrency( destination));
    }

    /**
     * Orders calender as day/month/year/hour/min
     * @return lastRetrievedArray int[]
     */
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
