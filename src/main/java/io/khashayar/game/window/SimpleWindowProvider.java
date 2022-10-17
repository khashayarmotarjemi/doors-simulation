package io.khashayar.game.window;

import io.khashayar.game.Door;

import java.util.ArrayList;

public class SimpleWindowProvider extends PoolWindowProvider {

    public SimpleWindowProvider(ArrayList<Door> doors, int windowSize) {
        super(doors);

        ArrayList<Door> d1 = new ArrayList<>();
        d1.add(doors.get(0));
        d1.add(doors.get(1));
        d1.add(doors.get(2));
        Window w1 = new Window(d1, 0.33);

        ArrayList<Door> d2 = new ArrayList<>();
        d2.add(doors.get(1));
        d2.add(doors.get(2));
        d2.add(doors.get(3));
        Window w2 = new Window(d2, 0.33);

        ArrayList<Door> d3 = new ArrayList<>();
        d3.add(doors.get(2));
        d3.add(doors.get(3));
        d3.add(doors.get(4));
        Window w3 = new Window(d3, 0.33);

        pool.add(w1);
        pool.add(w2);
        pool.add(w3);

    }

    @Override
    public Window getWindow() {
        double p = Math.random();
        double probSum = 0.0;

        for (Window w : pool) {
            probSum += w.prob;
            if (p <= probSum) {
                return w;
            }
        }
        return pool.get(pool.size() - 1);
    }
}
