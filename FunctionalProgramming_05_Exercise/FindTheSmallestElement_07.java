package FunctionalProgramming_05_Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class FindTheSmallestElement_07 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] inputArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> smallestElement = el -> {
            int max = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 0; i < el.length; i++) {
                if (max >= el[i]) {
                    max = el[i];
                    index = i;
                }
            }

            return index;
        };

        int min = smallestElement.apply(inputArr);

        System.out.println(min);

    }
}
