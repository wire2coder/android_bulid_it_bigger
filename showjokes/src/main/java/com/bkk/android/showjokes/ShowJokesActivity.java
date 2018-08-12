package com.bkk.android.showjokes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowJokesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_jokes);

        String gce_intent_data = getIntent().getStringExtra("gce_intent_data");
        TextView tv_gce_result = findViewById(R.id.tv_gce_result);

        tv_gce_result.setText(gce_intent_data);

    } // onCreate()

} // class
