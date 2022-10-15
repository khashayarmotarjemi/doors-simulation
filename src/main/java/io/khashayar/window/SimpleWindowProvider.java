package io.khashayar.window;

import java.util.ArrayList;

public class PoolWindowProvider extends WindowProvider {
    private final ArrayList<Window> pool;

    public PoolWindowProvider(ArrayList<Window> pool) {
        this.pool = pool;
    }

    @Override
    Window getWindow() {

    }
}
