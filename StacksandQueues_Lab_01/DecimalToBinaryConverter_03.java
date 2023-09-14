package StacksandQueues_Lab_01;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimal = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> binaryStack = new ArrayDeque<>();

        if(decimal == 0){
            System.out.println(0);
        }

        while (decimal > 0) {
            binaryStack.push(decimal % 2);
            decimal /= 2;
        }

        binaryStack.forEach(System.out::print);
    }
}
