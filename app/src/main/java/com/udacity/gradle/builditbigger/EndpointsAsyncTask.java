package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bkk.android.showjokes.ShowJokesActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {

    private static MyApi myApiService = null;
    private Context context;

    // for ProgressBar
    private View rootView;
    private ProgressBar progressBar1;


    public EndpointsAsyncTask(ProgressBar progressBar) {
        this.progressBar1 = progressBar;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        // make progress bar visible
        progressBar1.setVisibility(View.VISIBLE);
    }


    @Override
    protected String doInBackground(Pair<Context, String>... params) {

        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {

                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }

                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        context = params[0].first;
        String asdf = params[0].second;

        try {
            return myApiService.sayHi(asdf).execute().getData();
            // now go to onPostExecute()

        } catch (IOException e) {
            return e.getMessage();
        }

    } // doInBackground()

    @Override
    protected void onPostExecute(String result) {

        // Project requirement, click button >> lauch new activity (intent)
        progressBar1.setVisibility(View.GONE);

        Intent ShowJokesActivity = new Intent(context, ShowJokesActivity.class);
        ShowJokesActivity.putExtra("gce_intent_data", result);
        context.startActivity(ShowJokesActivity);

    } // onPostExecute()

} // class EndpointsAsyncTask
