package io.khashayar.game;

import io.khashayar.game.config.Config;
import io.khashayar.game.window.Window;

import java.util.ArrayList;

public class Agent {
    private final Sampler sampler;
    private final ArrayList<Door> memory = new ArrayList<>();

    public Agent(Config config) {
        this.sampler = new Sampler(config.inspectionRounds);
    }

    public void sample(Window window) {
        memory.clear();
        memory.addAll(sampler.sample(window));
    }

    public Door choose() {
        double maxP = 0;
        int doorNo = -1;
        for (Door d : memory) {
            if (d.prob > maxP) {
                maxP = d.prob;
                doorNo = d.number;
            }
        }
        return new Door(doorNo, maxP);
    }
}
