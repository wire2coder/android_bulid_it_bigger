package com.bkk.android.javajokes;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class Jokes {

    // asList is an "immutable" list
    List<String> alltheJokes =  asList(
            "What do you call the security outside of a Samsung Store?"
            , "Why was the stadium so cold?"
            , "What do you call a bee that was born is the United States?"
            , "Why can't a bike stand up on it's own?"
            , "What do we call a crying sister?"
            , "Why was the king only a foot tall?"
            , "What kind of music is a balloon scared of?"
    );


    public String getJoke() {

        // making a random number
        int ranNum = new Random().nextInt(6);
        return alltheJokes.get(ranNum);

    } // getJokes()


}// class Jokes
