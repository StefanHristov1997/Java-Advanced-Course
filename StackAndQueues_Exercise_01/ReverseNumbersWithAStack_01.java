package StackAndQueues_Exercise_01;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> reverseStack = new ArrayDeque<>();


        for (int number : numbers) {
            reverseStack.push(number);
        }

        while (reverseStack.size() > 0) {
            System.out.print(reverseStack.pop() + " ");
        }
    }
}
