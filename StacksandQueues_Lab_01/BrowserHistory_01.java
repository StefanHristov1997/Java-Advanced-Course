package StacksandQueues_Lab_01;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String navigation = scanner.nextLine();
        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        String currentURL = "";

        while (!navigation.equals("Home")) {

            if (navigation.equals("back")) {
                if (!browserHistory.isEmpty()) {
                    currentURL = browserHistory.pop();
                } else {
                    System.out.println("no previous URLs");
                    navigation = scanner.nextLine();
                    continue;
                }

            } else {
                if (!currentURL.isEmpty()) {
                    browserHistory.push(currentURL);
                }

                currentURL = navigation;
            }

            System.out.println(currentURL);
            navigation = scanner.nextLine();
        }


    }
}
