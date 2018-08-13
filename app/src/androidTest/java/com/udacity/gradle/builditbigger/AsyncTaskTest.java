package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;


@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule
            = new ActivityTestRule<>(MainActivity.class);



    @Test
    public void checkForJokes() {

        onView(withId(R.id.button_show_joke)).perform(click());

        // wait to see the screen animation on the 'device emulator'
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        // TODO: The tests must verify the return from the AsyncTask call to make sure that it's loading correctly the jokes from the GCE.

        onView(withId(R.id.tv_gce_result)).check(matches(not(withText(""))));

    }


} // class AsyncTaskTest

