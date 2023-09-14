package StacksandQueues_Lab_01;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String[] tokens = scanner.nextLine().split(" ");

        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = tokens.length - 1; i >= 0; i--) {
            stack.push(tokens[i]);
        }

        while (stack.size() > 1) {
            int firstNum = Integer.parseInt(stack.pop());
            String op = stack.pop();
            int secondNum = Integer.parseInt(stack.pop());

            switch (op) {
                case "+":
                    stack.push(String.valueOf(firstNum + secondNum));
                    break;
                case "-":
                    stack.push(String.valueOf(firstNum - secondNum));
                    break;
            }
        }

        System.out.println(stack.pop());
    }
}
