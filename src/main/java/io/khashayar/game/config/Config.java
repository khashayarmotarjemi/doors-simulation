package io.khashayar.game.config;

public class Config {
    public final int rounds;
    public final int inspectionRounds;

    public Config(int rounds, int inspection) {
        //TODO check if doors prob adds up to 1
        //TODO check for valid windows
        this.rounds = rounds;
        this.inspectionRounds = inspection;
    }
}

