package com.example.mgosling94.mastermind;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private HashMap<String, Integer> colorIdMap = new HashMap<String, Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Fills given hashmap with possible colors IDs
     *
     * @param hashMap HashMap to fill
     */
    protected void fillMapWithColors(HashMap<String, Integer> hashMap) {
        hashMap.put("Color1", R.color.color1);
        hashMap.put("Color2", R.color.color2);
        hashMap.put("Color3", R.color.color3);
        hashMap.put("Color4", R.color.color4);
        hashMap.put("Color5", R.color.color5);
        hashMap.put("Color6", R.color.color6);
    }

    /**
     * Update the graphical representation of the board
     */
    protected void updateBoard() {

    }

    /**
     * Take the current colors of the user input UI and pass it to business class
     */
    protected void submitGuess() {

    }

}
