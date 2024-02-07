package com.example.turncombatexample;

import java.util.Random;

public class Dice {
    private Random random;

    private int numberOfSides;

    public Dice() {
        this.numberOfSides = 6;
        random = new Random();
    }

    public Dice(int numberOfSides) {
        this.numberOfSides = numberOfSides;
        random = new Random();
    }

    public int returnNumberOfSides() {
        return numberOfSides;
    }

    public int roll() {
        return random.nextInt(numberOfSides) + 1;
    }

    @Override
    public String toString() {
        return String.format("Dice with %s sides", numberOfSides);
    }
}
