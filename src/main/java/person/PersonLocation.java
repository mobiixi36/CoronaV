package person;

import utils.MyRandom;

/**
 * @author xichen created on 06/02/2020
 */

public class PersonLocation {
    private double x;
    private double y;

    public PersonLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void next() {
        x += MyRandom.nextNumber(2);
        y += MyRandom.nextNumber(2);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
