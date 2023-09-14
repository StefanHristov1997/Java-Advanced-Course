package StacksandQueues_Lab_01;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MathPotato_07 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String[] players = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        PriorityQueue<String> winner = new PriorityQueue<>();

        for (String player : players) {
            winner.offer(player);
        }

        int cycle = 1;

        while (winner.size() > 1) {

            for (int i = 1; i < n; i++) {
                winner.offer(winner.poll());
            }

            if (isPrime(cycle)) {
                System.out.println("Prime " + winner.peek());
            } else {
                System.out.println("Removed " + winner.poll());
            }

            cycle++;
        }

        System.out.println("Last is " + winner.peek());
    }

    public static boolean isPrime(int cycle) {

        if (cycle <= 1) {
            return false;
        }

        for (int i = 2; i < cycle; i++) {
            if (cycle % i == 0) {
                return false;
            }
        }
        return true;
    }
}
