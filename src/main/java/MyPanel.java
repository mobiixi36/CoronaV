import city.Wuhan;
import person.Person;
import person.PersonLocation;
import utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * @author xichen created on 05/02/2020
 */

public class MyPanel extends JPanel {

    private Wuhan wuhan = Wuhan.getInstance();

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 800);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        setBackground(Color.BLACK);

        Graphics2D g2 = (Graphics2D) g;

        drawPersonDots(g2);

        Wuhan.TIME_ELAPSED ++;

        g.setColor(Color.WHITE);
        g.drawString(wuhan.getClass().getSimpleName(), 35, 35);

    }

    private void drawPersonDots(Graphics2D g) {
        for (Person person: wuhan.getPopulation().getPersonList()) {
            person.move();
            drawPerson(g, person);
        }
    }

    private void drawPerson(Graphics2D g, Person person) {
        PersonLocation location = person.getPersonLocation();
        Ellipse2D.Double personDot = new Ellipse2D.Double(location.getX(), location.getY(), Constants.DOT_SIZE, Constants.DOT_SIZE);
        g.setColor(person.getHealthCondition().getColor());
        g.fill(personDot);
    }
}
