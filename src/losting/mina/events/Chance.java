package losting.mina.events;

import java.util.Random;

public class Chance {

    public Double nextDouble() {
        double x = (new Random()).nextDouble();
        double y = (new Random()).nextDouble();
        return this.mid(x, y);
    }

    public int nextInt(int min, int max) {
        int x = (new Random()).nextInt(max) + min;
        int y = (new Random()).nextInt(max) + min;
        return this.mid(x, y);
    }

    private int mid(int x, int y) {
        return (x + y) / 2;
    }

    private Double mid(double x, double y) {
        return (x + y) / 2.0D;
    }
}
