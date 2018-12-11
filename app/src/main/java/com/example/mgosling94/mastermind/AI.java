package com.example.mgosling94.mastermind;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AI {
    // pegs are from 2-7
    private List<Peg[]> correctCombination;
    private Random rng = new Random();

    public List<Peg[]> createPegCombination()
    {
        List<Peg[]> newCombo = new ArrayList<>();
        for (int i = 0; i < 6; i++)
        {
            newCombo.add(new Peg[rng.nextInt(7-2+1)+2]);
        }
        setCorrectCombination(newCombo);
        return newCombo;
    }

    public List<Peg[]> getCorrectCombination() {
        return correctCombination;
    }

    private void setCorrectCombination(List<Peg[]> correctCombination) {
        this.correctCombination = correctCombination;
    }
    public List<Peg[]> checkCombination(List<Peg[]> toCheck)
    {
        List<Peg[]> correctPegs = new ArrayList<>();
        for (int i = 0; i <= toCheck.size(); i++)
        {
            for (int j = 0; i <= toCheck.size(); i++)
            {
                if (i != j && toCheck.get(i) == correctCombination.get(j))
                {
                    correctPegs.add(new Peg[0]);
                }
                else if ( i == j && toCheck.get(i) == correctCombination.get(j))
                {
                    correctPegs.add(new Peg[1]);
                }
            }
        }
        return correctPegs;
    }
}
