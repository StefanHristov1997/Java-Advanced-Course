package FunctionalProgramming_05_Lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().
                        split(", ")).map(Integer::parseInt).
                filter(e -> e % 2 == 0).
                collect(Collectors.toList());



        System.out.println(String.join(", ", numbers.toString() .replace("[","") .replace("]","")));
        Collections.sort(numbers);
        System.out.println(String.join(", ", numbers.toString() .replace("[","") .replace("]","")));

    }
}
