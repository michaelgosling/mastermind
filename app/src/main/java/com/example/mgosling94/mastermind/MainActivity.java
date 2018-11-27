package com.example.mgosling94.mastermind;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private int[] colors = new int[6];
    private Button[] userBtns = new Button[4];
    private Button userSubmitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set colors
        colors[0] = ContextCompat.getColor(this, R.color.color1);
        colors[1] = ContextCompat.getColor(this, R.color.color2);
        colors[2] = ContextCompat.getColor(this, R.color.color3);
        colors[3] = ContextCompat.getColor(this, R.color.color4);
        colors[4] = ContextCompat.getColor(this, R.color.color5);
        colors[5] = ContextCompat.getColor(this, R.color.color6);

        // find user buttons
        userBtns[0] = findViewById(R.id.userColorBtn1);
        userBtns[1] = findViewById(R.id.userColorBtn2);
        userBtns[2] = findViewById(R.id.userColorBtn3);
        userBtns[3] = findViewById(R.id.userColorBtn4);
        userSubmitBtn = findViewById(R.id.guessSubmitBtn);

        // for each button, assign this listener
        for (Button btn : userBtns) {
            btn.setOnClickListener(new View.OnClickListener() {

                /**
                 * Grabs the background color of the button, finds the equivalent index in the array
                 * increments the index by 1, and sets the button to the new color.
                 *
                 * @param v View
                 */
                @Override
                public void onClick(View v) {
                    ColorDrawable viewBG = (ColorDrawable) v.getBackground();
                    int bgColor = viewBG.getColor();
                    int bgColorIdx = 0;
                    for (int i = 0; i < colors.length; i++)
                        bgColorIdx = (colors[i] == bgColor) ? i : bgColorIdx;
                    bgColorIdx++;
                    bgColorIdx = (bgColorIdx > colors.length - 1) ? 0 : bgColorIdx;
                    ColorDrawable newBG = new ColorDrawable(colors[bgColorIdx]);
                    v.setBackground(newBG);
                }
            });
        }
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
