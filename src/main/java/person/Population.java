package person;

import city.City;
import utils.Constants;
import utils.MyRandom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xichen created on 06/02/2020
 *
 * //TODO: Make it thread safe
 */

public class Population {

    private static List<Person> personList = new ArrayList<>();
    private static List<Person> infectedPersonList = new ArrayList<>();
    private static Population population;

    public static Population getInstance(City city) {
        if (population == null) {
            population = new Population(city);
        }

        return population;
    }

    private Population(City city) {
        System.out.println("INITIALIZE POPULATION...");
        // populate the person list
        for (int i = 0; i < Constants.POPULATION; i++) {
            double x = city.getX() + MyRandom.nextGaussion() + 400;
            double y = city.getY() + MyRandom.nextGaussion() + 400;

            PersonLocation location = new PersonLocation(x, y);
            Person person = new Person(location);
            personList.add(person);
        }
    }

    public void startInitialInfection() {
        long totalNrOfPerson = this.getSize();
        for (int j = 0; j < Constants.INITIAL_INFECTED_NUMBER; j ++) {
            double randNumber = Math.random();
            int randomInfectedIdx = (int) Math.round(randNumber * totalNrOfPerson);

            Person infectedPerson = this.getPerson(randomInfectedIdx);
            infectedPerson.setHealthCondition(HealthCondition.SYMPTOMATIC);
            infectedPersonList.add(infectedPerson);
        }
    }

    public void addPerson(Person person) {
        personList.add(person);
    }

    public Person getPerson(int index) {
        return personList.get(index);
    }

    public int nrOfPerson() {
        return personList.size();
    }

    public List<Person> getInfectedPeople() {
        return infectedPersonList;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public long getSize() {
        return personList.size();
    }
}
