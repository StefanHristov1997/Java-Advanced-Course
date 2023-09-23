package FunctionalProgramming_05_Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FilterByAge_05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> personMap = readMap(scanner, n);

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        switch (condition) {
            case "older":
                for (String name : personMap.keySet()) {
                    if (age <= personMap.get(name)) {
                        switch (format) {
                            case "name age":
                                System.out.println(name + " - " + personMap.get(name));
                                break;
                            case "name":
                                System.out.println(name);
                                break;
                            case "age":
                                System.out.println(personMap.get(name));
                                break;
                        }
                    }
                }
                break;
            case "younger":
                for (String name : personMap.keySet()) {
                    if (age >= personMap.get(name)) {
                        switch (format) {
                            case "name age":
                                System.out.println(name + " - " + personMap.get(name));
                                break;
                            case "name":
                                System.out.println(name);
                                break;
                            case "age":
                                System.out.println(personMap.get(name));
                                break;
                        }
                    }
                }
                break;
        }

    }

    private static Map<String, Integer> readMap(Scanner scanner, int n) {

        Map<String, Integer> personMap = new LinkedHashMap<>();
        for (int i = 1; i <= n; i++) {
            String[] data = scanner.nextLine().split(",\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            personMap.put(name, age);
        }
        return personMap;
    }

}
