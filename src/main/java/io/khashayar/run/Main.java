package io.khashayar.run;

import io.khashayar.game.config.Config;
import io.khashayar.game.Door;
import io.khashayar.game.Result;
import io.khashayar.game.Sim;
import io.khashayar.game.window.SimpleWindowProvider;
import io.khashayar.game.window.SizedRandomWindowProvider;
import io.khashayar.game.window.WindowProvider;
import io.khashayar.run.model.Plot;
import io.khashayar.run.model.RunResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final Config config = new Config(1000, 100);

        final ArrayList<Door> doors = new ArrayList<Door>() {
            {
                add(new Door(1, 0.4));
                add(new Door(2, 0.25));
                add(new Door(3, 0.12));
                add(new Door(4, 0.15));
                add(new Door(5, 0.08));
            }
        };

        for (int i = 1; i <= 5; i++) {
            final WindowProvider srwp = new SizedRandomWindowProvider(doors, i);

            final Sim simulation = new Sim(config, srwp);
            Result result = simulation.run();
            System.out.println("Window Size: " + i);
            System.out.println("Door frequency: " + result.doorFreq());
            System.out.println("Intensity: " + measureIntensity(new ArrayList<>(List.of(1, 2)), new ArrayList<>(List.of(3, 4, 5)), result.selection));
            System.out.println();
        }

    }

    public static void showPlot() {
        try {
            new ProcessBuilder("python", "plot_result.py").start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static double measureIntensity(ArrayList<Integer> optimal, ArrayList<Integer> suboptimal, ArrayList<Integer> selected) {
        int o = 0;
        int so = 0;

        for (int door : selected) {
            if (optimal.contains(door)) {
                o++;
            } else if (suboptimal.contains(door)) {
                so++;
            }
        }

        return (double) so / o;

    }
}