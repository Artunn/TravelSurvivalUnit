package com.example.asusnb.travelsurvivalunit;

/**
 * Created by User on 10.05.2018.
 */

public class SubQuestions {
    String[] question;
    //int category;
    boolean hasSpace;

    public SubQuestions( String first, String second, boolean hasSpace) {
        question = new String[2];
        question[0] = first;
        question[1] = second;

       // this.category = category;
        this.hasSpace = hasSpace;
    }

}
