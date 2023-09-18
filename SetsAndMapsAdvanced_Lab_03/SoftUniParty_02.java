package SetsAndMapsAdvanced_Lab_03;

import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniParty_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String invitedGuests = scanner.nextLine();

        TreeSet<String> vipGuest = new TreeSet<>();
        TreeSet<String> regularGuest = new TreeSet<>();

        while (!invitedGuests.equals("PARTY")) {
            String guest = invitedGuests;

            char firstSymbol = guest.charAt(0);

            if (Character.isDigit(firstSymbol)) {
                vipGuest.add(guest);
            } else {
                regularGuest.add(guest);
            }

            invitedGuests = scanner.nextLine();
        }

        String arrivedGuests = scanner.nextLine();

        while (!arrivedGuests.equals("END")) {

            if (vipGuest.contains(arrivedGuests)) {
                vipGuest.remove(arrivedGuests);
            } else if (regularGuest.contains(arrivedGuests)) {
                regularGuest.remove(arrivedGuests);
            }

            arrivedGuests = scanner.nextLine();
        }

        int allGuests = vipGuest.size() + regularGuest.size();

        System.out.println(allGuests);
        vipGuest.forEach(System.out::println);
        regularGuest.forEach(System.out::println);
    }
}

