package io.khashayar.game.window;

import io.khashayar.game.Door;

import java.util.ArrayList;

public class Window {
    public final ArrayList<Door> doors;
    public final double prob;

    public Window(ArrayList<Door> doors, double prob) {
        this.doors = doors;
        this.prob = prob;
    }
}
