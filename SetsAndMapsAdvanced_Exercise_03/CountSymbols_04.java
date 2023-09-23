package SetsAndMapsAdvanced_Exercise_03;

import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String text = scanner.nextLine();

        TreeMap<Character, Integer> characterMap = new TreeMap<>();

        for (char symbol : text.toCharArray()) {

            if (!characterMap.containsKey(symbol)) {
                characterMap.put(symbol, 1);
            } else {
                characterMap.put(symbol, characterMap.get(symbol) + 1);
            }
        }

        characterMap.forEach((key, value) -> System.out.printf("%s: %d time/s\n", key, value));
    }
}
