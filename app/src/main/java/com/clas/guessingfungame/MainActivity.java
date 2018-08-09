package com.clas.guessingfungame;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
//    private GameFragment[] questions;
//    private int currentActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        questions = GenerateQuizPages();
    }

    protected void onClickStart(View v) {
//        currentActivity = 0;
//        setContentView(R.layout.activity_game);
//        FragmentManager fm = getFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.replace(R.id.quiz_frag, questions[currentActivity]);
//        ft.commit();
        Intent i = new Intent(this, GameActivity.class);
        i.putExtra("collection", getGameNames());
        i.putExtra("position", 0);
        startActivity(i);
    }

//    public void onCorrect() {
//        currentActivity++;
//        setContentView(R.layout.activity_game);
//        FragmentManager fm = getFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.replace(R.id.quiz_frag, questions[currentActivity]);
//        ft.commit();
//    }
//
//    private GameFragment[] GenerateQuizPages(){
//        GameFragment[] output = new GameFragment[10];
//        String[] names = getGameNames();
//        int[] imgs = getGamePics();
//
//        for(int i = 0; i < names.length; i++){
//            GameFragment temp = (GameFragment)getFragmentManager().findFragmentById(R.id.quiz_frag);
//            //new GameFragment();
//            String answer = names[i];
//            String[] options = getRandomOptions(names, answer);
//            int img = imgs[i];
//            temp.create( options, answer, img);
//            output[i] = temp;
//        }
//        return output;
//    }
//
    private String[] getGameNames(){
        String[] output = new String[10];
        output[0]= getString(R.string.game_10);
        output[1]= getString(R.string.game_9);
        output[2]= getString(R.string.game_8);
        output[3]= getString(R.string.game_7);
        output[4]= getString(R.string.game_6);
        output[5]= getString(R.string.game_5);
        output[6]= getString(R.string.game_4);
        output[7]= getString(R.string.game_3);
        output[8]= getString(R.string.game_2);
        output[9]= getString(R.string.game_1);
        return output;
    }
//
//    private int[] getGamePics(){
//        int[] output = new int[10];
//        //Uri.Builder b = new Uri.Builder();
//        output[0]= R.drawable.game_10_neverwinternights_img;
//        output[1]=  R.drawable.game_9_spacewar_img;
//        output[2]=  R.drawable.game_8_elite_img;
//        output[3]=  R.drawable.game_7_minesweeper_img;
//        output[4]=  R.drawable.game_6_halflife_img;
//        output[5]=  R.drawable.game_5_civilization_img;
//        output[6]=  R.drawable.game_4_worldofwarcraft_img;
//        output[7]=  R.drawable.game_3_sims_img;
//        output[8]=  R.drawable.game_2_tetris_img;
//        output[9]= R.drawable.game_1_doom_img;
//        return output;
//    }
//
//    private boolean contains(String[] options, String s){
//        for (int i = 0; i < options.length; i++){
//
//            if(options[i] == null)
//                return false;
//            else if(options[i].equalsIgnoreCase(s))
//                return true;
//        }
//        return false;
//    }
//
//    private String[] getRandomOptions(String[] names,String answer){
//        String[] options = new String[4];
//        options[0] = answer;
//        Random rand = new Random();
//        for(int i = 1; i < 4; i++) {
//            String name = names[rand.nextInt(names.length)];
//            while (contains(options, name)) {
//                name = names[rand.nextInt(names.length)];
//            }
//            options[i] = name;
//        }
//        return options;
//    }
}
