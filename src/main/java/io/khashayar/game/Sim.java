package io.khashayar.game;

import io.khashayar.game.config.Config;
import io.khashayar.game.window.Window;
import io.khashayar.game.window.WindowProvider;

public class Sim {
    private final Config config;
    private final Agent agent;
    private final Result result;

    private final WindowProvider windowProvider;

    public Sim(Config c, WindowProvider wp, Agent agent) {
        this.config = c;
        this.agent =agent;
        this.result = new Result(c);
        this.windowProvider = wp;
    }

    public Result run() {

        for (int r = 1; r <= config.rounds; r++) {
            final Window window = windowProvider.getWindow();
            agent.sample(window);
            result.addWindow(window);
            final Door chosenDoor = agent.choose();
            result.addDoor(chosenDoor);
        }

        return result;
    }

}
