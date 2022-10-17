package io.khashayar.game.window;

import io.khashayar.game.Door;

import java.util.ArrayList;

public abstract class WindowProvider {
    public WindowProvider(ArrayList<Door> doors) {
        this.doors = doors;
    }

    public abstract Window getWindow();

    protected final ArrayList<Door> doors;
}
