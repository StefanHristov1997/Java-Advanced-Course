package StacksandQueues_Lab_01;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fileName = scanner.nextLine();

        ArrayDeque<String> printOrder = new ArrayDeque<>();


        while (!fileName.equals("print")) {


            if (fileName.equals("cancel")) {

                if (!printOrder.isEmpty()) {
                    System.out.printf("Canceled %s\n", printOrder.poll());
                } else {
                    System.out.println("Printer is on standby");
                }

            } else {
                printOrder.offer(fileName);
            }

            fileName = scanner.nextLine();
        }

        printOrder.forEach(System.out::println);
    }
}
