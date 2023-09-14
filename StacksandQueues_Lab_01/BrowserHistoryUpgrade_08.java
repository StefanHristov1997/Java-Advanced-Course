package StacksandQueues_Lab_01;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade_08 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String command = scanner.nextLine();
        ArrayDeque<String> history = new ArrayDeque<>();
        ArrayDeque<String> forwardPages = new ArrayDeque<>();
        String currentURL = "";


        while (!command.equals("Home")) {

            if (command.equals("back")) {
                if (!history.isEmpty()) {
                    currentURL = history.pop();
                    forwardPages.offer(currentURL);
                } else {
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                }

            } else if (command.equals("forward")) {

                if (!forwardPages.isEmpty()) {
                    currentURL = forwardPages.pop();
                } else {
                    System.out.println("no next URLs");
                    command = scanner.nextLine();
                    continue;
                }

            } else {

                if (!currentURL.isEmpty()) {
                    history.push(currentURL);
                }

                currentURL = command;
                forwardPages.clear();

            }

            System.out.println(currentURL);
            command = scanner.nextLine();
        }
    }
}
