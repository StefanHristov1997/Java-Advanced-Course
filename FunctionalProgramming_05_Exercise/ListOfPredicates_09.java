package FunctionalProgramming_05_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class ListOfPredicates_09 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int range = Integer.parseInt(scanner.nextLine());
        List<Integer> divisibleNumbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        divisibleNumbers = divisibleNumbers.stream().filter(num -> num > 0).collect(Collectors.toList());

        BiFunction<Integer, List<Integer>, Boolean> isDivisible = (num, list) -> {
            for (int numInList : list) {
                if (num % numInList != 0) {
                    return false;
                }
            }
            return true;
        };

        for (int number = 1; number <= range; number++) {
            if (isDivisible.apply(number, divisibleNumbers)){
                System.out.print(number + " ");
            }
        }
    }
}

