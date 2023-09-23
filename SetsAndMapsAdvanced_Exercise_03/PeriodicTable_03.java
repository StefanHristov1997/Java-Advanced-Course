package SetsAndMapsAdvanced_Exercise_03;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        TreeSet<String> periodicTableSet = new TreeSet<>();

        for (int row = 1; row <= rows; row++) {
            String[] data = scanner.nextLine().split("\\s+");

            periodicTableSet.addAll(Arrays.asList(data));
        }

        periodicTableSet.forEach(e -> System.out.print(e + " "));
    }
}
