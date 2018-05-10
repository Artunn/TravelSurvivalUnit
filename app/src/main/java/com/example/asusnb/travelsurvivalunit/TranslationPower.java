package com.example.asusnb.travelsurvivalunit;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by User on 10.05.2018.
 */

public class TranslationPower {
    Category[] categories;

    public TranslationPower (){
        categories = new Category[6];
        for( int i = 0; i < 6; i++) {
            categories[i] = new Category( UniversalData.CATEGORIES[0][i]);
        }

    }

    public void fillDatasIn() {
        File file = new File("c1");
        try {
            FileInputStream fis = new FileInputStream(file);
            Scanner scan = new Scanner(fis);
            while (scan.hasNext()) {
                String x = scan.nextLine();
                boolean b;
                String[] prop = x.split(":");

                if (prop[3] == "+") {
                    b = true;
                } else {
                    b = false;
                }

                SubQuestions newSub = new SubQuestions(prop[0], prop[1], b);
                categories[Integer.parseInt(prop[2])].subs.add(newSub);
            }
        }
        catch (Exception e) {

        }
    }


    private class Category {

        String categoryName;
        ArrayList<SubQuestions> subs;

        private Category( String inCategory) {
            categoryName = inCategory;
            subs = new ArrayList<>();

        }
    }

}
