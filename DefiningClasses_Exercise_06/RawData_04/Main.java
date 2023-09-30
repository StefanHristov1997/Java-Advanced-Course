package RawData_04;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        List<Car> carList = new ArrayList<>();

        for (int i = 1; i <= numberOfCars; i++) {
            String[] information = scanner.nextLine().split("\\s+");
            String model = information[0];
            int engineSpeed = Integer.parseInt(information[1]);
            int enginePower = Integer.parseInt(information[2]);
            int cargoWeight = Integer.parseInt(information[3]);
            String cargoType = information[4];
            double tirePressure1 = Double.parseDouble(information[5]);
            int tireAge1 = Integer.parseInt(information[6]);
            double tirePressure2 = Double.parseDouble(information[7]);
            int tireAge2 = Integer.parseInt(information[8]);
            double tirePressure3 = Double.parseDouble(information[9]);
            int tireAge3 = Integer.parseInt(information[10]);
            double tirePressure4 = Double.parseDouble(information[11]);
            int tireAge4 = Integer.parseInt(information[12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            LinkedHashMap<Double, Integer> tires = new LinkedHashMap<>();

            tires.put(tirePressure1, tireAge1);
            tires.put(tirePressure2, tireAge2);
            tires.put(tirePressure3, tireAge3);
            tires.put(tirePressure4, tireAge4);


            Car car = new Car(model, engine, cargo, tires);
            carList.add(car);

        }

        String command = scanner.nextLine();

        List<Car> filteredList;
        List<Car> finalListOfCars;

        switch (command) {
            case "fragile":
                filteredList = carList.stream().filter(e -> e.getCargo().getType().equals("fragile")).collect(Collectors.toList());
                finalListOfCars = filteredList.stream().filter(e -> fragileCommand(e.getTires())).collect(Collectors.toList());
                for (Car car : finalListOfCars) {
                    System.out.println(car);
                }
                break;
            case "flamable":
                filteredList = carList.stream().filter(e -> e.getCargo().getType().equals("flamable")).collect(Collectors.toList());
                finalListOfCars = filteredList.stream().filter(Main::flamableCommand).collect(Collectors.toList());
                for (Car car : finalListOfCars) {
                    System.out.println(car);
                }
                break;
        }

    }

    public static boolean fragileCommand(Map<Double, Integer> tires) {
        boolean isValid = false;

        for (Double pressure : tires.keySet()) {
            if (pressure < 1) {
                return true;
            }
        }
        return isValid;
    }

    public static boolean flamableCommand(Car car) {
        return car.getEngine().getEnginePower() > 250;
    }
}