package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bkk.android.javajokes.Jokes;


public class MainActivity extends AppCompatActivity {
    // MainActivity is SHARED between FREE and PAID version

    private ProgressBar progressBar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar1 = findViewById(R.id.progressBar1);

    } // onCreate()


    public void tellJoke(View view) {

        // run a new AsyncTask that grab "jokes" from local server.
        new EndpointsAsyncTask(progressBar1)
                .execute( new Pair<Context, String> (this, "asdf" ) );

    }

} // class MainActivity
