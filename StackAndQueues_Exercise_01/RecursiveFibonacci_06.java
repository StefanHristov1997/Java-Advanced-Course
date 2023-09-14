package StackAndQueues_Exercise_01;

import java.util.Scanner;

public class RecursiveFibonacci_06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        System.out.println(fib(number));

    }

    public static long fib(int n) {

        if (n <= 2) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }
}
