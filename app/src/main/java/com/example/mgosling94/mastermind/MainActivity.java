package com.example.mgosling94.mastermind;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private ColorStateList[] colors = new ColorStateList[6];
    private Button[] userBtns = new Button[4];
    private Button userSubmitBtn;
    private Board board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set colors
        colors[0] = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.color1));
        colors[1] = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.color2));
        colors[2] = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.color3));
        colors[3] = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.color4));
        colors[4] = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.color5));
        colors[5] = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.color6));

        // find user buttons
        userBtns[0] = findViewById(R.id.userColorBtn1);
        userBtns[1] = findViewById(R.id.userColorBtn2);
        userBtns[2] = findViewById(R.id.userColorBtn3);
        userBtns[3] = findViewById(R.id.userColorBtn4);
        userSubmitBtn = findViewById(R.id.guessSubmitBtn);

        // set each button to a color from the list
        for (int i = 0; i < userBtns.length; i++)
            userBtns[i].setBackgroundTintList(colors[i]);

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
                    // get the current background color and look up it's index in colors
                    int bgColorIdx = 0;
                    for (int i = 0; i < colors.length; i++)
                        bgColorIdx = (colors[i].getDefaultColor() == v.getBackgroundTintList().getDefaultColor()) ? i : bgColorIdx;
                    // increment the index by 1 and assign the new color corresponding to the new index
                    bgColorIdx++;
                    bgColorIdx = (bgColorIdx > colors.length - 1) ? 0 : bgColorIdx;
                    v.setBackgroundTintList(colors[bgColorIdx]);
                }
            });
        }
    }

    /**
     * Update the graphical representation of the board
     */
    protected void updateBoard() {
        for (Peg[] row : board.GetHistory()) {
            for (Peg peg : row) {

            }
        }
    }

    /**
     * Take the current colors of the user input UI and pass it to business class
     */
    protected void submitGuess() {

    }

}
