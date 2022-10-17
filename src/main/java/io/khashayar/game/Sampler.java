package io.khashayar.game;

import io.khashayar.game.window.Window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Sampler {
    private ArrayList<Door> sampled;
    private final int rounds;
    private static final double eps = 0.001;

    public Sampler(int rounds) {
        this.rounds = rounds;
    }

    public ArrayList<Door> sample(Window window) {
        final int windowSize = window.doors.size();
        double[] probSamples = new double[windowSize];
        Arrays.fill(probSamples, 1.0 / windowSize);

        for (int i = 0; i < rounds; i++) {
            int choice = (int) (Math.random() * (windowSize));
            boolean won = tryDoor(window.doors.get(choice));

            for (Door door : window.doors) {
                int index = window.doors.indexOf(door);

                if (index == choice) {
                    if (won) {
                        probSamples[index] += eps;
                    } else {
                        probSamples[index] -= eps;
                    }
                } else {
                    if (won) {
                        probSamples[index] -= eps / (windowSize);
                    } else {
                        probSamples[index] += eps / (windowSize - 1);
                    }
                }
            }

        }

        return window.doors.stream().map(door -> new Door(door.number, probSamples[window.doors.indexOf(door)])).collect(Collectors.toCollection(ArrayList::new));
    }

    private boolean tryDoor(Door door) {
        return Math.random() < door.prob;
    }

}
