package OpinionPoll_01;

import java.util.TreeMap;

public class Person {

    private TreeMap<String, Integer> persons;

    public Person(TreeMap<String, Integer> persons) {

        this.persons = persons;
    }

    public TreeMap<String, Integer> getPersons() {

        return persons;
    }

}
