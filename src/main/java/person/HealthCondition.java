package person;

import java.awt.*;

/**
 * @author xichen created on 07/02/2020
 */

public enum HealthCondition {
    HEALTHY(1, Color.GREEN) ,
    INCUBATION(2, Color.YELLOW),
    SYMPTOMATIC(3, Color.RED),
    TREATING(4, Color.PINK),
    RECOVERED(5, Color.GREEN);

    private int id;
    private Color color;
    HealthCondition(int id, Color color) {
        this.id = id;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public Color getColor() {
        return color;
    }
}
