package SetsAndMapsAdvanced_Lab_03;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop_06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        TreeMap<String, LinkedHashMap<String, Double>> shopMap = new TreeMap<>();


        while (!command.equals("Revision")) {
            String shop = command.split(",\\s+")[0];
            String product = command.split(",\\s+")[1];
            double price = Double.parseDouble(command.split(",\\s+")[2]);


            if (!shopMap.containsKey(shop)) {
                shopMap.put(shop, new LinkedHashMap<>());
            }

            shopMap.get(shop).put(product, price);

            command = scanner.nextLine();
        }

        shopMap.entrySet().forEach(shop -> {
            System.out.println(shop.getKey() + "->");
            shop.getValue().entrySet().stream().forEach(product -> {
                System.out.printf("Product: %s, Price: %.1f\n", product.getKey(), product.getValue());
            });
        });

    }
}
