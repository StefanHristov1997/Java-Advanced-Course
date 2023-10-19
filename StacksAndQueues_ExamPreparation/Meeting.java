package StacksAndQueues_ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> males = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(males::push);

        ArrayDeque<Integer> females = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(females::offer);

        int matches = 0;

        while (!females.isEmpty() && !males.isEmpty()) {
            int firstFemale = females.peek();
            int lastMale = males.peek();

            if (firstFemale <= 0) {
                females.poll();
                continue;
            } else if (lastMale <= 0) {
                males.pop();
                continue;
            }

            if (firstFemale % 25 == 0) {
                females.poll();
                females.poll();
                continue;
            } else if (lastMale % 25 == 0) {
                males.pop();
                males.pop();
                continue;
            }

            if (firstFemale == lastMale) {
                females.poll();
                males.pop();
                matches++;
            } else {
                females.poll();
                lastMale -= 2;
                males.pop();
                males.push(lastMale);
            }

        }

        System.out.printf("Matches: %d\n", matches);

        if (males.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");
            System.out.println(String.join(", ", males.toString().replaceAll("[\\[\\]]", "")));
        }

        if (females.isEmpty()) {
            System.out.print("Females left: none");
        } else {
            System.out.print("Females left: ");
            System.out.println(String.join(", ", females.toString().replaceAll("[\\[\\]]", "")));
        }

    }
}
