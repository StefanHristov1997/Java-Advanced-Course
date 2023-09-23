package SetsAndMapsAdvanced_Exercise_03;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsernames_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        LinkedHashSet<String> usernameSet = new LinkedHashSet<>();

        for (int row = 1; row <= rows; row++) {
            String usernames = scanner.nextLine();
            usernameSet.add(usernames);
        }

        usernameSet.forEach(System.out::println);
    }
}
