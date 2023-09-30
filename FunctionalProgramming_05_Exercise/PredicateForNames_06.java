package FunctionalProgramming_05_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames_06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Predicate<String> namesFilter = e -> e.length() > n;

        for (int i = 0; i < names.size(); i++) {
            if (namesFilter.test(names.get(i))) {
                names.remove(names.get(i));
                i--;
            }
        }
        names.forEach(System.out::println);
    }

}

