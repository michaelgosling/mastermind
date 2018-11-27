package com.example.mgosling94.mastermind;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private int[] colorIds = {R.color.color1, R.color.color2, R.color.color3, R.color.color4,
            R.color.color5, R.color.color6};
    private Button[] userBtns = {findViewById(R.id.userColorBtn1), findViewById(R.id.userColorBtn2),
            findViewById(R.id.userColorBtn3), findViewById(R.id.userColorBtn4)};
    private Button userSubmitBtn = findViewById(R.id.guessSubmitBtn);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (Button btn : userBtns) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ColorDrawable viewBG = (ColorDrawable) v.getBackground();
                    int bgColor = viewBG.getColor();
                    int bgColorIdx = 0;
                    for (int i = 0; i < colorIds.length; i++)
                        bgColorIdx = (colorIds[i] == bgColor) ? i : bgColorIdx;
                    bgColorIdx++;
                    bgColorIdx = (bgColorIdx > colorIds.length - 1) ? 0 : bgColorIdx;
                    ColorDrawable newBG = new ColorDrawable(colorIds[bgColorIdx]);
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
