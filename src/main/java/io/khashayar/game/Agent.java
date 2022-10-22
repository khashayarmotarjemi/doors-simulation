package io.khashayar.game;

import io.khashayar.game.window.Window;

public interface Agent {
    public void sample(Window window);

    public Door choose();
}
