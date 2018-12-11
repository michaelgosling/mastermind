package com.example.mgosling94.mastermind;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Peg[]> history = new ArrayList<Peg[]>();

    public List<Peg[]> GetHistory() {
        return this.history;
    }
}
