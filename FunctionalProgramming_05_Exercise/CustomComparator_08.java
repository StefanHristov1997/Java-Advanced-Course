package FunctionalProgramming_05_Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomComparator_08 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> evenNumbers = numbers.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
        List<Integer> oddNumbers = numbers.stream().filter(num -> num % 2 != 0).collect(Collectors.toList());

        Collections.sort(evenNumbers);
        Collections.sort(oddNumbers);

        evenNumbers.forEach(e -> System.out.print(e + " "));
        oddNumbers.forEach(e -> System.out.print(e + " "));

    }
}