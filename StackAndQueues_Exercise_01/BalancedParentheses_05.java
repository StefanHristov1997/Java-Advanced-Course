package StackAndQueues_Exercise_01;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses_05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();

        boolean areBalanced = false;

        for (char symbol : input.toCharArray()) {

            if (symbol == '(' || symbol == '{' || symbol == '[') {
                stack.push(symbol);
            } else if (symbol == ')' || symbol == '}' || symbol == ']') {
                if (stack.isEmpty()) {
                    areBalanced = false;
                    break;
                }

                char lastOpenBracket = stack.pop();


                if (lastOpenBracket == '(' && symbol == ')') {
                    areBalanced = true;
                } else if (lastOpenBracket == '{' && symbol == '}') {
                    areBalanced = true;
                } else if (lastOpenBracket == '[' && symbol == ']') {
                    areBalanced = true;
                } else {
                    areBalanced = false;
                    break;
                }

            }
        }

        if (areBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
