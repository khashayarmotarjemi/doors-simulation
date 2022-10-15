package io.khashayar.configuration;

import io.khashayar.Door;

import java.util.ArrayList;

public class Game {
    public final int rounds;
    public final int inspection;
    private final ArrayList<Door> doors;


    public Game(int rounds, int inspection) {
        this.rounds = rounds;
        this.inspection = inspection;
    }
}

