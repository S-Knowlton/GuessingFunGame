package com.clas.guessingfungame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    private int score;
    private TextView TextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_fragment);
        Intent i = getIntent();
        score = i.getIntExtra("score", 0);
        TextView = (TextView) findViewById(R.id.textView);

        TextView.setText(TextView.getText()+  " "  + score);


    }
}
