package SetsAndMapsAdvanced_Lab_03;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class ParkingLot_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashSet<String> cars = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String command = input.split(",\\s+")[0];
            String carRegistration = input.split(",\\s+")[1];

            if (command.equals("IN")) {
                cars.add(carRegistration);
            } else if (command.equals("OUT")) {
                cars.remove(carRegistration);
            }

            input = scanner.nextLine();
        }

        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            cars.forEach(System.out::println);
        }
    }
}
