package com.example.asusnb.travelsurvivalunit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class WorldClocks extends AppCompatActivity {

    Calendar calendar;
    String zone;
    String time;
    int gmtZeroHour;
    int gmtZeroMinute;
    int gmtZeroSecond;
    int timeZoneHour;
    int timeZoneMinute;
    boolean zonePositive;
    TextView istanbulText;
    TextView moscowText;
    TextView newYorkText;
    TextView tokyoText;
    TextView berlinText;
    TextView londonText;
    TextView losAngelesText;
    TextView hongKongText;
    TextView rioDeJenarioText;
    TextView dubaiText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_clocks);
        Timer timer = new Timer();
        setGmtZeroTime();
        findViews();
        setTimes();

        timer.schedule( new UsedTask(), 0, 1000);


    }
    public void setTimes() {
        setTimeOnView( istanbulText, "istanbul", 3);
        setTimeOnView( hongKongText, "hong kong", 8);
        setTimeOnView( newYorkText, "new york", -4);
        setTimeOnView( berlinText, "berlin", 2);
        setTimeOnView( tokyoText, "tokyo", 9);
        setTimeOnView( dubaiText, "dubai", 4);
        setTimeOnView( rioDeJenarioText, "rio de jenario", -3);
        setTimeOnView( moscowText, "moscow", 3);
        setTimeOnView( losAngelesText, "lost angeles", -7);
        setTimeOnView( londonText, "london", 1);
    }

    public void setGmtZeroTime() {
        calendar = new GregorianCalendar();
        String[] timeInfo = calendar.getTime().toString().split(" ");
        time = timeInfo[3];
        zone = timeInfo[4].substring(4, timeInfo[4].length());
        zonePositive = timeInfo[4].charAt(3) == '+';

        String[] splittedTime = time.split(":");
        String[] splittedTimeZone = zone.split(":");

        System.out.println( calendar.getTime());
        timeZoneHour = Integer.parseInt(splittedTimeZone[0]);
        timeZoneMinute = Integer.parseInt(splittedTimeZone[1]);

        if( zonePositive) {
            gmtZeroHour = (Integer.parseInt(splittedTime[0]) - timeZoneHour) % 24;


            gmtZeroMinute = (Integer.parseInt(splittedTime[1]) - timeZoneMinute) % 60;
            if( gmtZeroMinute < 0) {
                gmtZeroMinute = gmtZeroMinute + 60;
                gmtZeroHour--;
            }
            if( gmtZeroHour < 0) {
                gmtZeroHour = gmtZeroHour + 24;
            }
        }

        else {
            gmtZeroHour = (Integer.parseInt(splittedTime[0]) + timeZoneHour) % 24;
            if( Integer.parseInt(splittedTime[1]) + timeZoneMinute > 59) {

                gmtZeroHour = (gmtZeroHour + 1) % 24;
            }
            gmtZeroMinute = (Integer.parseInt(splittedTime[1]) + timeZoneMinute) % 60;
        }
        System.out.println(gmtZeroHour);
        gmtZeroSecond = Integer.parseInt(splittedTime[2]);
        System.out.println( gmtZeroMinute);

    }
    public void findViews() {
        istanbulText = findViewById( R.id.istanbul);
        hongKongText = findViewById( R.id.hong_kong);
        dubaiText = findViewById( R.id.dubai);
        londonText = findViewById( R.id.london);
        tokyoText = findViewById( R.id.tokyo);
        rioDeJenarioText = findViewById( R.id.rio_de_janerio);
        losAngelesText = findViewById( R.id.los_angeles);
        moscowText = findViewById( R.id.moscow);
        newYorkText = findViewById( R.id.new_york);
        berlinText = findViewById( R.id.berlin);
    }

    public void setTimeOnView(TextView view, String cityName, int timeZone) {
        int cityHour;
        String hourText;
        String minuteText;
        String secondText;

        cityHour = (gmtZeroHour + timeZone)%24;
        if( cityHour < 0) {
            cityHour = cityHour + 24;
        }
        if( cityHour < 10) {
            hourText = "0" + cityHour;
        }
        else {
            hourText = "" + cityHour;
        }
        if( gmtZeroMinute < 10) {
            minuteText = "0" + gmtZeroMinute;
        }
        else {
            minuteText = "" + gmtZeroMinute;
        }
        if( gmtZeroSecond < 10) {
            secondText = "0" + gmtZeroSecond;
        }
        else {
            secondText = "" + gmtZeroSecond;
        }
        String toSet;
        toSet = cityName + "\n" + hourText + ":" + minuteText + ":" + secondText;
        view.setText( toSet);
    }
    private class UsedTask extends TimerTask {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(gmtZeroSecond + 1 > 59) {
                        gmtZeroMinute = gmtZeroMinute + 1;

                    }
                    gmtZeroSecond = (gmtZeroSecond + 1)%60;
                    if (gmtZeroMinute > 59) {
                        gmtZeroHour = gmtZeroHour +1;
                        gmtZeroMinute = 0;
                    }
                    if( gmtZeroHour > 23) {
                        gmtZeroHour = 0;
                    }
                    setTimes();
                }
            });
        }
    }
}