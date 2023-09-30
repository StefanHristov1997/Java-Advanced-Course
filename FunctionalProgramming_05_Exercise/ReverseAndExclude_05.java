package FunctionalProgramming_05_Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseAndExclude_05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = readList(scanner);
        int n = Integer.parseInt(scanner.nextLine());

        numbers = numbers.stream().filter(num -> num % n != 0).collect(Collectors.toList());

        Collections.reverse(numbers);

        numbers.forEach(e-> System.out.print(e + " "));


    }

    private static List<Integer> readList(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
