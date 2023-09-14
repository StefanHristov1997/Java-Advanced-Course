package StacksandQueues_Lab_01;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato_06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> children = new ArrayDeque<>();

        String[] players = scanner.nextLine().split(" ");
        int toss = Integer.parseInt(scanner.nextLine());

        for (String player : players) {
            children.offer(player);
        }

        while (children.size() > 1) {

            for (int i = 1; i < toss; i++) {
                children.offer(children.poll());
            }

            System.out.printf("Removed %s\n", children.poll());
        }

        System.out.println("Last is " + children.peek());
    }
}
