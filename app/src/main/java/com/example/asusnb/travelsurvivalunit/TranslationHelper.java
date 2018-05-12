package com.example.asusnb.travelsurvivalunit;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by User on 10.05.2018.
 */

public class TranslationHelper implements Serializable {
    Category[] categories;

    public TranslationHelper( Context context) {
        categories = new Category[6];
        for( int i = 0; i < 6; i++) {
            categories[i] = new Category( UniversalData.CATEGORIES[i][0]);
        }
        fillDatasIn( context);
    }

    public ArrayList<SubQuestion> getSubsFromHelper(int x) {
        return categories[x].getSubs();
    }

    public void fillDatasIn( Context context)  {
        try {
            InputStream inputStream = context.getAssets().open("subquestions");
            Scanner scan = new Scanner( inputStream);

            String nextLine;
            String space;
            String[] propertiesOfSubQuestion;

            while ( scan.hasNextLine()) {
                nextLine = scan.nextLine();

                propertiesOfSubQuestion = nextLine.split(":");
                space = propertiesOfSubQuestion[3];

                SubQuestion newSub = new SubQuestion(propertiesOfSubQuestion[0],
                        propertiesOfSubQuestion[1], space);
                categories[ Integer.parseInt( propertiesOfSubQuestion[2])].subQuestions.add(newSub);
            }
            scan.close();
        }
        catch (IOException e) {
                e.printStackTrace();
        }
    }

    private class Category implements Serializable {

        String categoryName;
        ArrayList<SubQuestion> subQuestions;

        private Category( String inCategory) {
            categoryName = inCategory;
            subQuestions = new ArrayList<>();
        }
        public ArrayList<SubQuestion> getSubs() {
            return subQuestions;
        }
    }

}
