package com.bkk.android.javajokes;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class Jokes {

    List<String> alltheJokes =  asList("joke1"
            , "joke2", "joke3"
            ,"joke4","joke5"
            ,"joke6","joke7");



    public String getJoke() {
        // making a random number
        int ranNum = new Random().nextInt(6);
        return alltheJokes.get(ranNum);
    }

}// class Jokes
