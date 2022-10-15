package io.khashayar;

import java.util.ArrayList;

public class Window {
    public final ArrayList<Door> doors;
    public final int prob;

    public Window(ArrayList<Door> doors, int prob) {
        this.doors = doors;
        this.prob = prob;
    }
}
