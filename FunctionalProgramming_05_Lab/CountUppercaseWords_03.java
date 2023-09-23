package FunctionalProgramming_05_Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> text = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());


        Predicate<Character> isUpperCase = Character::isUpperCase;

        int count = 0;
        List<String> words = new ArrayList<>();

        for (String symbol : text) {
            if (isUpperCase.test(symbol.charAt(0))) {
                count++;
                words.add(symbol);
            }
        }

        System.out.println(count);
        words.forEach(System.out::println);
    }
}