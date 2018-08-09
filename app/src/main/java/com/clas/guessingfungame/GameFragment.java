package com.clas.guessingfungame;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
//import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class GameFragment extends Fragment {
    private String[] options;
    private String answer;
    private ImageView image;
    private OnItemSelectedListener listener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.quiz_fragment);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.quiz_fragment, container, false);
        Button button = (Button) view.findViewById(R.id.radioButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail(((Button)v).getText().toString());
            }
        });
        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implemenet MyListFragment.OnItemSelectedListener");
        }
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
    public interface OnItemSelectedListener {
        public void onRssItemSelected(String link);
    }
    public void updateDetail(String selection) {
        if(isRight(selection)) {
            onDetach();
            Toast.makeText(getActivity(), "Correct", Toast.LENGTH_SHORT).show();
            GameActivity m = (GameActivity)getActivity();
            m.onCorrect();
        }else {
            Toast.makeText(getActivity(), "Incorrect", Toast.LENGTH_SHORT).show();
        }
        String newTime = String.valueOf(System.currentTimeMillis());
        listener.onRssItemSelected(newTime);
    }

    private boolean isRight(String s){
        return s.equalsIgnoreCase(answer);
    }
    public void create(String[] options, String answer, int pic){
        //setContentView(view);
        image = getView().findViewById(R.id.imageView);
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
            Button b = (Button)getView().findViewById(ids.get(num));
            b.setText(options[i++]);
            ids.remove(num);
        }
    }
}