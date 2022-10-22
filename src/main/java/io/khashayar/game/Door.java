package io.khashayar.game;

public class Door {
    public final int number;
    public final double prob;

    public Door(int number, double prob) {
        this.number = number;
        this.prob = prob;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Door && ((Door) obj).number == number;
    }
}
