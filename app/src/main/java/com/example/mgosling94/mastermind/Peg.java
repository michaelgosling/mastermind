package com.example.mgosling94.mastermind;

public class Peg {

    public enum PegColor {
        White, Black, Color1, Color2, Color3, Color4, Color5, Color6
    }

    /* Properties */
    private PegColor color;
    private boolean isKey;

    /* Accessors & Mutators */
    public PegColor getColor() {
        return color;
    }

    /* Constructor */
    public Peg(PegColor color, boolean isKey) {
        this.color = color;
        this.isKey = isKey;
    }

}
