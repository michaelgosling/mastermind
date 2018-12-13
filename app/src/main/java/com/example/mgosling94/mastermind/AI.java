package com.example.mgosling94.mastermind;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AI {
    // pegs are from 2-7
    private Peg[] correctCombination = new Peg[4];
    private Random rng = new Random();

    private Peg.PegColor getPegColor(int idx) {
        Peg.PegColor pegColor;
        switch (idx) {
            default:
                pegColor = Peg.PegColor.Color1;
                break;
            case 1:
                pegColor = Peg.PegColor.Color2;
                break;
            case 2:
                pegColor = Peg.PegColor.Color3;
                break;
            case 3:
                pegColor = Peg.PegColor.Color4;
                break;
            case 4:
                pegColor = Peg.PegColor.Color5;
                break;
            case 5:
                pegColor = Peg.PegColor.Color6;
                break;
        }
        return pegColor;
    }

    public List<Peg> createPegCombination()
    {
        List<Peg> newCombo = new ArrayList<>();
        for (int i = 0; i < 4; i++)
        {
            int colorIdx = rng.nextInt(6);
            newCombo.add(new Peg(getPegColor(colorIdx), false));
        }

        Peg[] newComboArray = new Peg[4];
        int i = 0;
        for (Peg peg : newCombo) {
            newComboArray[i] = peg;
            i++;
        }
        setCorrectCombination(newComboArray);
        return newCombo;
    }

    public Peg[] getCorrectCombination() {
        return correctCombination;
    }

    private void setCorrectCombination(Peg[] correctCombination) {
        this.correctCombination = correctCombination;
    }

    public List<Peg> checkCombination(Peg[] toCheck)
    {
        List<int[]> correctPegs = new ArrayList<>();

        for (int i = 0; i < toCheck.length; i++) {
            for (int j = 0; j < 4; j++) {
                if (toCheck[i].getColor() == correctCombination[j].getColor()) {
                    int[] rightGuess;
                    if (i == j)
                        rightGuess = new int[]{i, 1};
                    else
                        rightGuess = new int[]{i, 0};
                    correctPegs.add(rightGuess);
                    break;
                }
            }
        }

        List<Peg> pegsToReturn = new ArrayList<>();

        for (int[] i : correctPegs) {
            if (i[1] == 0)
                pegsToReturn.add(new Peg(Peg.PegColor.White, true));
            else
                pegsToReturn.add(new Peg(Peg.PegColor.Black, true));
        }

        while (pegsToReturn.size() < 4) {
            pegsToReturn.add(new Peg(Peg.PegColor.KeyWrong, true));
        }

        return pegsToReturn;
    }
}
