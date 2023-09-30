package FunctionalProgramming_05_Exercise;

import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        Consumer<String[]> printInput = text -> {
            for (String el : text) {
                System.out.println(el);
            }
        };

        printInput.accept(input);
    }
}
