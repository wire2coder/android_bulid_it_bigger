package com.bkk.android.javajokes;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class Jokes {

    // asList is an "immutable" list
    List<String> alltheJokes =  asList(
            "Joke: What do you call the security outside of a Samsung Store?"
            , "Joke: Why was the stadium so cold?"
            , "Joke: What do you call a bee that was born is the United States?"
            , "Joke: Why can't a bike stand up on it's own?"
            , "Joke: What do we call a crying sister?"
            , "Joke: Why was the king only a foot tall?"
            , "Joke: What kind of music is a balloon scared of?"
    );


    public String getJoke() {

        // making a random number
        int ranNum = new Random().nextInt(6);
        return alltheJokes.get(ranNum);

    } // getJokes()


}// class Jokes
