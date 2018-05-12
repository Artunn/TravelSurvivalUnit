package com.example.asusnb.travelsurvivalunit;

import android.content.Context;
import android.provider.Settings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by User on 10.05.2018.
 */

public class TranslationPower implements Serializable {
    Category[] categories;

    public TranslationPower( Context context) {
        categories = new Category[6];
        for( int i = 0; i < 6; i++) {
            categories[i] = new Category( UniversalData.CATEGORIES[i][0]);
        }
        fillDatasIn( context);

    }
    public ArrayList<SubQuestions> getSubsx( int x) {
        return categories[x].getSubs();
    }

    public void fillDatasIn( Context context)  {
        try {

            InputStream is = context.getAssets().open("subquestions");
            System.out.println("wow");
            Scanner scan = new Scanner( is);

            while ( scan.hasNextLine()) {
                String x = scan.nextLine();
                String b;
                String[] prop = x.split(":");

                b = prop[3];

                SubQuestions newSub = new SubQuestions(prop[0], prop[1], b);
                categories[Integer.parseInt( prop[2])].subs.add(newSub);
            }
            //fis.close();
            scan.close();
        }
        catch (IOException e) {
                e.printStackTrace();
        }
    }

    private class Category implements Serializable {

        String categoryName;
        ArrayList<SubQuestions> subs;

        private Category( String inCategory) {
            categoryName = inCategory;
            subs = new ArrayList<>();
        }
        public ArrayList<SubQuestions> getSubs() {
            return subs;
        }
    }

}
