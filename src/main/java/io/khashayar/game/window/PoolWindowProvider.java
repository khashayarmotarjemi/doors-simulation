package io.khashayar.game.window;

import io.khashayar.game.Door;

import java.util.ArrayList;

public class PoolWindowProvider extends WindowProvider {
    protected final ArrayList<Window> pool = new ArrayList<>();

    public PoolWindowProvider(ArrayList<Door> doors) {
        super(doors);
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
        return pool.get(pool.size() -1 );
    }
}
