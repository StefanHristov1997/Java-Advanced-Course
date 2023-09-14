package StackAndQueues_Exercise_01;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int S = scanner.nextInt();
        int X = scanner.nextInt();

        ArrayDeque<Integer> stack = new ArrayDeque<>();


        for (int i = 1; i <= N; i++) {
            stack.push(scanner.nextInt());
        }

        for (int i = 1; i <= S; i++) {
            stack.pop();
        }

        if (stack.contains(X)) {
            System.out.println("true");
        } else {
            if (stack.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(Collections.min(stack));
            }
        }
    }
}
