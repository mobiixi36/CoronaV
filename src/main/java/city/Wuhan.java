package city;

import person.Person;
import person.Population;
import utils.Constants;

import java.awt.*;

/**
 * @author xichen created on 06/02/2020
 */

public class Wuhan implements City {
    public static int TIME_ELAPSED = 0;
    private double x;
    private double y;
    private Population population;
    private static Wuhan wuhan;

    private Wuhan(double x, double y) {
        this.population = Population.getInstance(this);
        this.population.startInitialInfection();
    }

    public static Wuhan getInstance() {
        if (wuhan == null) {
            wuhan = new Wuhan(400, 400);
        }
        return wuhan;
    }

    public Population getPopulation() {
        return population;
    }

    @Override
    public double getX() {
        return 0;
    }

    @Override
    public double getY() {
        return 0;
    }
}
