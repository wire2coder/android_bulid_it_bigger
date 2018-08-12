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


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }


    Jokes jokes1 = new Jokes();

    public void tellJoke(View view) {

        String joke1 = jokes1.getJoke();
        new EndpointsAsyncTask(progressBar1).execute( new Pair<Context, String> (this, joke1 ) );

    }

} // class MainActivity
