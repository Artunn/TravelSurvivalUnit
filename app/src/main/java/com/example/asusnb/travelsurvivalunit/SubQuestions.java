package com.example.asusnb.travelsurvivalunit;

import java.io.Serializable;

/**
 * Created by User on 10.05.2018.
 */

public class SubQuestions implements Serializable {
    String[] question;
    String space;

    public SubQuestions( String first, String second, String space) {
        question = new String[2];
        question[0] = first;
        question[1] = second;

       // this.category = category;
        this.space = space;
    }

}
