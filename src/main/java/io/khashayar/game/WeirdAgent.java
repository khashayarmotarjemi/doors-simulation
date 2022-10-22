package io.khashayar.game;

import io.khashayar.game.config.Config;
import io.khashayar.game.window.Window;

import java.util.ArrayList;

public class WeirdAgent implements Agent {
    private final Sampler sampler;
    private final ArrayList<Door> memory = new ArrayList<>();
    private final ArrayList<Door> allDoors;

    public WeirdAgent(Config config, ArrayList<Door> allDoors) {
        this.sampler = new Sampler(config.inspectionRounds);
        this.allDoors = allDoors;
    }

    @Override
    public void sample(Window window) {
        memory.clear();
        final ArrayList<Door> sampled = sampler.sample(window);
        final ArrayList<Door> others = new ArrayList<>();

        for (Door door : allDoors) {
            if (!sampled.contains(door)) {
                Door guessDoor = new Door(door.number, 1.0 / allDoors.size());
                others.add(guessDoor);
            }
        }

        memory.addAll(others);
        memory.addAll(sampled);
    }

    @Override
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
