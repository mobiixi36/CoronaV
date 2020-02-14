package person;

import city.Wuhan;
import utils.Constants;

import static person.HealthCondition.*;

/**
 * @author xichen created on 05/02/2020
 */

public class Person {
    private PersonLocation personLocation;
    private HealthCondition healthCondition;

    private int incubationTime = 0;

    public Person(PersonLocation personLocation) {
        this.personLocation = personLocation;
        this.healthCondition = HEALTHY;
    }

    public void move() {
        personLocation.next();
        for (Person person : Wuhan.getInstance().getPopulation().getPersonList()) {
            if (person.healthCondition != SYMPTOMATIC) {
                continue;
            }

            if (this.distanceTo(person) < Constants.SAFE_DISTANCE
                    && this.healthCondition.getId() < INCUBATION.getId()) {
                System.out.println("CONDITION: incubation");
                this.setHealthCondition(INCUBATION);
            }

            // the person is already in incubation period, let's simulate the time elapsed during that condition
            if (this.healthCondition == INCUBATION) {
                incubationTime ++;
            }

            // if the person is in incubation condition and has reached the incubation period,
            // he/she turns to symptomatic condition, which can infect other people
            if (incubationTime == Constants.INCUBATION_PERIOD
                    && this.healthCondition == INCUBATION) {
                System.out.println("CONDITION: symptomatic");
                this.setHealthCondition(SYMPTOMATIC);
            }
        }
    }

    public PersonLocation getPersonLocation() {
        return personLocation;
    }

    public void setPersonLocation(PersonLocation personLocation) {
        this.personLocation = personLocation;
    }

    public HealthCondition getHealthCondition() {
        return healthCondition;
    }

    public void setHealthCondition(HealthCondition healthCondition) {
        this.healthCondition = healthCondition;
    }

    public double distanceTo(Person person) {
        return Math.sqrt(Math.pow(personLocation.getX() - person.getPersonLocation().getX(), 2)
                + Math.pow(personLocation.getY() - person.getPersonLocation().getY(), 2));
    }
}
