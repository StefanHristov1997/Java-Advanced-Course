package Google_07;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String command = scanner.nextLine();

        Map<String, Person> personMap = new LinkedHashMap<>();

        while (!command.equals("End")) {
            String[] personInformation = command.split("\\s+");
            String name = personInformation[0];

            if (!personMap.containsKey(name)) {
                personMap.put(name, new Person());
            }

            switch (personInformation[1]) {
                case "company":
                    String companyName = personInformation[2];
                    String department = personInformation[3];
                    double salary = Double.parseDouble(personInformation[4]);

                    Company company = new Company(companyName, department, salary);
                    personMap.get(name).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = personInformation[2];
                    String pokemonType = personInformation[3];

                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    personMap.get(name).getPokemons().add(pokemon);
                    break;
                case "parents":
                    String parentName = personInformation[2];
                    String parentBirthday = personInformation[3];

                    Parent parent = new Parent(parentName, parentBirthday);
                    personMap.get(name).getParents().add(parent);
                    break;
                case "children":
                    String childName = personInformation[2];
                    String childBirthday = personInformation[3];

                    Child children = new Child(childName, childBirthday);
                    personMap.get(name).getChildren().add(children);
                    break;
                case "car":
                    String carModel = personInformation[2];
                    int carSpeed = Integer.parseInt(personInformation[3]);

                    Car car = new Car(carModel, carSpeed);
                    personMap.get(name).setCar(car);
                    break;
            }


            command = scanner.nextLine();
        }

        String givenName = scanner.nextLine();

        System.out.println(givenName);

        Person person = personMap.get(givenName);

        System.out.println(person);
    }
}
