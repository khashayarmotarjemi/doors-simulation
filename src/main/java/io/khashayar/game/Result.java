package io.khashayar.game;

import io.khashayar.game.config.Config;
import io.khashayar.game.window.Window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Result {
    private final Config config;
    public final ArrayList<Integer> selection = new ArrayList<>();

    public Result(Config config) {
        this.config = config;
    }

    public void addDoor(Door door) {
        selection.add(door.number);
    }

    public void addWindow(Window window) {
    }

    // <door number, frequency>
    public Map<Integer, Integer> doorFreq() {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int door : selection) {
            if (freq.containsKey(door)) {
                freq.put(door, freq.get(door) + 1);
            } else {
                freq.put(door, 1);
            }
        }
        return freq;
    }
}
