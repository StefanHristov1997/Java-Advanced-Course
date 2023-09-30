package OpinionPoll_01;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, Integer> persons = new TreeMap<>();

        for (int i = 1; i <= n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            if (age > 30) {
                persons.put(name, age);
            }
        }
        Person person = new Person(persons);

        person.getPersons().forEach((key, value) -> System.out.println(key + " - " + value));
    }
}
