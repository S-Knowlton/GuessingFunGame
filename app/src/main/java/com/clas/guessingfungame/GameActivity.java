package com.clas.guessingfungame;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
//    private GameFragment[] questions;
    private int currentActivity;
    private String[] games;
    private String[] options;
    private String answer;
    private ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_fragment);
        Intent i = getIntent();
        currentActivity = i.getIntExtra("position", 0);
        games = i.getStringArrayExtra("collection");
        build();
//        questions = GenerateQuizPages();
    }

//    protected void onClickStart() {
////        setContentView(R.layout.activity_game);
//        FragmentManager fm = getFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.replace(R.id.quiz_frag, new GameFragment(), "tag");
//        ft.commit();
//        GameFragment gf = (GameFragment) getSupportFragmentManager().findFragmentByTag("tag");


//    }

    public void OnRadioButtonClicked(View w){

        RadioButton  rb1 = (RadioButton) findViewById(R.id.radioButton);
        RadioButton  rb2 = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton  rb3 = (RadioButton) findViewById(R.id.radioButton3);
        RadioButton  rb4 = (RadioButton) findViewById(R.id.radioButton4);
        Random random = new Random();

        boolean checked = ((RadioButton) w).isChecked();

        switch (w.getId()){

            case R.id.radioButton:
                if(checked)

                    rb1.setTypeface(null, Typeface.BOLD_ITALIC);
                    rb2.setTypeface(null, Typeface.NORMAL);
                    rb3.setTypeface(null, Typeface.NORMAL);
                    rb4.setTypeface(null, Typeface.NORMAL);



                if(isRight((rb1).getText().toString())){
                    Toast.makeText(GameActivity.this, "Correct!", Toast.LENGTH_LONG).show();
                    onCorrect();

                }
                else{
                    Toast.makeText(GameActivity.this, "Wrong!", Toast.LENGTH_LONG).show();
                }


                    break;

            case R.id.radioButton2:
                if(checked)
                    rb1.setTypeface(null, Typeface.NORMAL);
                    rb2.setTypeface(null, Typeface.BOLD_ITALIC);
                    rb3.setTypeface(null, Typeface.NORMAL);
                    rb4.setTypeface(null, Typeface.NORMAL);
                    isRight((rb1).getText().toString());
                    break;

            case R.id.radioButton3:
                if(checked)
                    rb1.setTypeface(null, Typeface.NORMAL);
                    rb2.setTypeface(null, Typeface.NORMAL);
                    rb3.setTypeface(null, Typeface.BOLD_ITALIC);
                    rb4.setTypeface(null, Typeface.NORMAL);
                    isRight((rb1).getText().toString());
                break;
            case R.id.radioButton4:
                if(checked)
                    rb1.setTypeface(null, Typeface.NORMAL);
                    rb2.setTypeface(null, Typeface.NORMAL);
                    rb3.setTypeface(null, Typeface.NORMAL);
                    rb4.setTypeface(null, Typeface.BOLD_ITALIC);
                    isRight((rb1).getText().toString());
                break;
        }
    }

    public void onCorrect() {
        currentActivity++;
        Intent i = new Intent(this, GameActivity.class);
        i.putExtra("collection", games);
        i.putExtra("position", currentActivity);
        startActivity(i);
    }

    private void build(){
        String[] ops = getRandomOptions(games, games[currentActivity]);
        String game = games[currentActivity];

        create(ops, game, getGamePics()[currentActivity]);
    }

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

    private int[] getGamePics(){
        int[] output = new int[10];
        //Uri.Builder b = new Uri.Builder();
        output[0]= R.drawable.game_10_neverwinternights_img;
        output[1]=  R.drawable.game_9_spacewar_img;
        output[2]=  R.drawable.game_8_elite_img;
        output[3]=  R.drawable.game_7_minesweeper_img;
        output[4]=  R.drawable.game_6_halflife_img;
        output[5]=  R.drawable.game_5_civilization_img;
        output[6]=  R.drawable.game_4_worldofwarcraft_img;
        output[7]=  R.drawable.game_3_sims_img;
        output[8]=  R.drawable.game_2_tetris_img;
        output[9]= R.drawable.game_1_doom_img;
        return output;
    }

    private boolean contains(String[] options, String s){
        for (int i = 0; i < options.length; i++){

            if(options[i] == null)
                return false;
            else if(options[i].equalsIgnoreCase(s))
                return true;
        }
        return false;
    }

    private String[] getRandomOptions(String[] names,String answer){
        String[] options = new String[4];
        options[0] = answer;
        Random rand = new Random();
        for(int i = 1; i < 4; i++) {
            String name = names[rand.nextInt(names.length)];
            while (contains(options, name)) {
                name = names[rand.nextInt(names.length)];
            }
            options[i] = name;
        }
        return options;
    }

    private boolean isRight(String s){
        return s.equalsIgnoreCase(answer);
    }

    public void create(String[] options, String answer, int pic){
        //setContentView(view);
        image = findViewById(R.id.imageView);
        image.setImageResource(pic);
        this.answer = answer;
        this.options = options;
        setButtonText();
    }

    private void setButtonText(){
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(R.id.radioButton);
        ids.add(R.id.radioButton2);
        ids.add(R.id.radioButton3);
        ids.add(R.id.radioButton4);
        int i = 0;
        while (ids.size() > 0){
            Random rand = new Random();
            int num = rand.nextInt(ids.size());
            Button b = (Button)findViewById(ids.get(num));
            b.setText(options[i++]);
            ids.remove(num);
        }
        options[0] = ((Button)findViewById(R.id.radioButton)).getText().toString();
        options[1] = ((Button)findViewById(R.id.radioButton4)).getText().toString();
        options[2] = ((Button)findViewById(R.id.radioButton3)).getText().toString();
        options[3] = ((Button)findViewById(R.id.radioButton2)).getText().toString();
    }




//        FragmentManager fm = getFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.replace(R.id.quiz_frag, questions[currentActivity]);
//        ft.commit();

//    private GameFragment[] GenerateQuizPages(){
//        GameFragment[] output = new GameFragment[10];
//        String[] names = getGameNames();
//        int[] imgs = getGamePics();
//
//        for(int i = 0; i < names.length; i++){
//            //GameFragment temp = (GameFragment)getFragmentManager().findFragmentById(R.id.quiz_frag);
//            GameFragment temp = new GameFragment();
//            String answer = names[i];
//            String[] options = getRandomOptions(names, answer);
//            int img = imgs[i];
//            temp.create( options, answer, img);
//            output[i] = temp;
//        }
//        return output;
//    }

//    protected void onClickStart() {
////        setContentView(R.layout.activity_game);
//        FragmentManager fm = getFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.replace(R.id.quiz_frag, new GameFragment(), "tag");
//        ft.commit();
//        GameFragment gf = (GameFragment) getSupportFragmentManager().findFragmentByTag("tag");
//    }
}
