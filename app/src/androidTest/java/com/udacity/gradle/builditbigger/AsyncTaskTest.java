package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.bkk.android.javajokes.Jokes;

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

    String connectionError = EndpointsAsyncTask.connectionError;

    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule
            = new ActivityTestRule<>(MainActivity.class);



    @Test
    public void checkForJokes() {

        onView(withId(R.id.button_show_joke)).perform(click());

        // wait to see the screen animation on the 'device emulator'
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // fixed, requirement for project submission number 2
        /* You have to make sure the joke is not an error for the test to work as expected.
            This test will never fail, even if you run it when the GCE isn't running. */
        onView(withId(R.id.tv_gce_result)).check(matches(not(withText("connectionerror:111"))));

        // wait to see the screen animation on the 'device emulator'
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


} // class AsyncTaskTest

