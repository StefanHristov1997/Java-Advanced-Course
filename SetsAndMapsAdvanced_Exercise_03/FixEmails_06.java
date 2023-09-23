package SetsAndMapsAdvanced_Exercise_03;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, String> emailsMap = new LinkedHashMap<>();

        while (!command.equals("stop")) {
            String name = command;
            String email = scanner.nextLine();

            if(email.endsWith("com") || email.endsWith("us") || email.endsWith("uk")){
                command = scanner.nextLine();
                continue;
            }else{
                emailsMap.put(name, email);
            }

            command = scanner.nextLine();
        }

        emailsMap.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}