package com.example.asusnb.travelsurvivalunit;

import java.io.Serializable;

/**
 * Created by User on 10.05.2018.
 */

public class SubQuestion implements Serializable {
    String[] question;
    String space;

    public SubQuestion(String turkish, String english, String space) {
        question = new String[2];
        question[0] = turkish;
        question[1] = english;

       // this.category = category;
        this.space = space;
    }

}
