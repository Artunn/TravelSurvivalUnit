package com.example.asusnb.travelsurvivalunit;

public class Language implements UniversalData {
    //properties
    String  name;

    //constructors
    public Language(String name)
    {
        this.name = name;
    }

    // methods
    public String translate( String[][] motherLanguage , String[][] targetLanguage , String sentence)
    {
        int row ;
        int column;
        row = -1;
        column = -1;

        for (int i = 0 ; i < motherLanguage.length ; i++)
        {
            for ( int j = 0 ; j < motherLanguage[i].length ; j ++)
            {
                if ( sentence.equals(motherLanguage[i][j])) {
                    row = i ;
                    column = j ;

                }
            }
        }
        return targetLanguage [row][column];
    }
}

