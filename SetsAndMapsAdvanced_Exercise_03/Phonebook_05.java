package SetsAndMapsAdvanced_Exercise_03;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Phonebook_05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        LinkedHashMap<String, String> phonebookMap = new LinkedHashMap<>();

        while (!input.equals("search")) {

            String name = input.split("-")[0];
            String phoneNumber = input.split("-")[1];

            if (!phonebookMap.containsKey(name)) {
                phonebookMap.put(name, phoneNumber);
            } else {
                phonebookMap.put(name, phoneNumber);
            }

            input = scanner.nextLine();
        }

        String check = scanner.nextLine();

        while (!check.equals("stop")) {

            if (phonebookMap.containsKey(check)) {
                System.out.println(check + " -> " + phonebookMap.get(check));
            }else{
                System.out.printf("Contact %s does not exist.\n", check);
            }

            check = scanner.nextLine();
        }

    }
}
