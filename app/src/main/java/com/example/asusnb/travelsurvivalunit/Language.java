    package com.example.asusnb.travelsurvivalunit;

    import com.example.asusnb.travelsurvivalunit.UniversalData;

    public class Language implements UniversalData {
            //properties
            String  name;
            //consturctors
            public Language(String name)
            {
                this.name = name;
            }
            // methods
            public String translate( String[][] motherLanguage , String[][] targetLanguage , String sentence)
            {
                int row ;
                int coloumn;
                row = -1;
                coloumn = -1;

                for (int i = 0 ; i < motherLanguage.length ; i++)
                {
                    for ( int j = 0 ; j < motherLanguage[i].length ; j ++)
                    {
                        if ( sentence.equals(motherLanguage[i][j])) {
                            row = i ;
                            coloumn = j ;

                        }
                    }
                }
                return targetLanguage [row][coloumn];
            }

        }

