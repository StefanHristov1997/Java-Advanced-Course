package SetsAndMapsAdvanced_Lab_03;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CitiesByContinentAndCountry_07 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int rows = Integer.parseInt(scanner.nextLine());

        Map<String, LinkedHashMap<String, ArrayList<String>>> worldMap = new LinkedHashMap<>();

        for (int row = 1; row <= rows; row++) {
            String[] data = scanner.nextLine().split("\\s+");
            String continent = data[0];
            String country = data[1];
            String city = data[2];

            if (!worldMap.containsKey(continent)) {
                worldMap.put(continent, new LinkedHashMap<>());
                worldMap.get(continent).put(country, new ArrayList<>());
                worldMap.get(continent).get(country).add(city);
            } else {
                if (!worldMap.get(continent).containsKey(country)) {
                    worldMap.get(continent).put(country, new ArrayList<>());
                    worldMap.get(continent).get(country).add(city);
                } else {
                    worldMap.get(continent).get(country).add(city);
                }

            }

        }

        worldMap.forEach((key, value) -> {
            System.out.println(key + ":");
            value.forEach((key1, value1) ->
                    System.out.printf("%s -> %s\n", key1, value1.toString().replaceAll("[\\[\\]]", "")));
        });
    }
}
