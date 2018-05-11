package com.example.asusnb.travelsurvivalunit;

import java.io.Serializable;

/**
 * Created by User on 10.05.2018.
 */

public class SubQuestions implements Serializable {
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
