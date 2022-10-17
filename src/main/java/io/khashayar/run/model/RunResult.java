package io.khashayar.run.model;

import java.util.ArrayList;
import java.util.List;

public class RunResult {
    final int agentId;
    final ArrayList<Integer> results;

    public RunResult(int agentId, ArrayList<Integer> results) {
        this.agentId = agentId;
        this.results = results;
    }
}
