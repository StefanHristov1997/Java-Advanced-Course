package SetsAndMapsAdvanced_Lab_03;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CountRealNumbers_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        LinkedHashMap<Double, Integer> numbersMap = new LinkedHashMap<>();

        for (double value : input) {

            if (!numbersMap.containsKey(value)) {
                numbersMap.put(value, 1);
            } else {
                numbersMap.put(value, numbersMap.get(value) + 1);
            }
        }

        numbersMap.forEach((key, value) -> System.out.printf("%.1f -> %d\n", key, value));
    }
}
