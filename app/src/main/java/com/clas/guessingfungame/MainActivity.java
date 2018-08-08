package com.clas.guessingfungame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;

public class MainActivity extends AppCompatActivity {
    private Layout[] questions = new Layout[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
