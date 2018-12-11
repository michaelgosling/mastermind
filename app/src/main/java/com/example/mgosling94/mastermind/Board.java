package com.example.mgosling94.mastermind;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Peg[]> history = new ArrayList<Peg[]>();

    public List<Peg[]> GetHistory() {
        return this.history;
    }

    public void AddGuess(Peg[] userGuess, Peg[] keyPegs) {
        Peg[] entry = new Peg[userGuess.length + keyPegs.length];
        for (int i = 0; i < entry.length; i++) {
            if (i < userGuess.length)
                entry[i] = userGuess[i];
            else
                entry[i] = keyPegs[i];
        }
        history.add(entry);
    }
}
