package CarSalesman_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Engine> engineList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] engineInfo = scanner.nextLine().split("\\s+");
            Engine engine = null;
            String model = "";
            int power = 0;
            int displacement = 0;

            String efficiency = "";


            if (engineInfo.length == 2) {
                model = engineInfo[0];
                power = Integer.parseInt(engineInfo[1]);
                engine = new Engine(model, power);
            } else if (engineInfo.length == 3) {
                String thirdElement = engineInfo[2];

                if (Character.isLetter(thirdElement.charAt(0))) {
                    model = engineInfo[0];
                    power = Integer.parseInt(engineInfo[1]);
                    efficiency = thirdElement;
                    engine = new Engine(model, power, efficiency);
                } else {
                    model = engineInfo[0];
                    power = Integer.parseInt(engineInfo[1]);
                    displacement = Integer.parseInt(thirdElement);
                    engine = new Engine(model, power, displacement);
                }

            } else {
                model = engineInfo[0];
                power = Integer.parseInt(engineInfo[1]);
                displacement = Integer.parseInt(engineInfo[2]);
                efficiency = engineInfo[3];

                engine = new Engine(model, power, displacement, efficiency);
            }


            engineList.add(engine);
        }

        int m = Integer.parseInt(scanner.nextLine());

        List<Car> carList = new ArrayList<>();

        for (int i = 1; i <= m; i++) {
            String[] carInfo = scanner.nextLine().split("\\s+");

            String model = carInfo[0];
            String engine = carInfo[1];
            Car car = null;

            if (carInfo.length == 2) {
                car = new Car(model, engineCompare(engineList, engine));
            } else if (carInfo.length == 3) {
                String thirdElement = carInfo[2];

                if (Character.isLetter(thirdElement.charAt(0))) {
                    String color = thirdElement;
                    car = new Car(model, engineCompare(engineList, engine), color);
                } else {
                    int weight = Integer.parseInt(carInfo[2]);
                    car = new Car(model, engineCompare(engineList, engine), weight);
                }
            } else {
                int weight = Integer.parseInt(carInfo[2]);
                String color = carInfo[3];
                car = new Car(model, engineCompare(engineList, engine), weight, color);
            }

            carList.add(car);
        }

        carList.forEach(System.out::println);
    }

    public static Engine engineCompare(List<Engine> engines, String engine) {
        for (Engine el : engines) {
            if (el.getModel().equals(engine)) {
                return el;
            }
        }
        return null;
    }
}
