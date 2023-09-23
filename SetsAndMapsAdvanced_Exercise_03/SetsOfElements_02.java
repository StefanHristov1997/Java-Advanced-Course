package SetsAndMapsAdvanced_Exercise_03;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>();


        for (int rows = 1; rows <= n; rows++) {
            int number = Integer.parseInt(scanner.nextLine());
            firstSet.add(number);
        }

        for (int rows = 1; rows <= m; rows++) {
            int number = Integer.parseInt(scanner.nextLine());
            secondSet.add(number);
        }

        for (Integer i : firstSet) {
            int current = i;
            for (int j : secondSet) {
                if (current == j) {
                    System.out.print(current + " ");
                }
            }
        }
    }
}
