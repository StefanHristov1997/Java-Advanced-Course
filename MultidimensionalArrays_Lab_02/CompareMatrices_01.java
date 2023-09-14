package MultidimensionalArrays_Lab_02;

import java.util.Scanner;

public class CompareMatrices_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] parameters = scanner.nextLine().split("\\s+");
        int firstRows = Integer.parseInt(parameters[0]);
        int firstCols = Integer.parseInt(parameters[1]);

        int[][] firstMatrix = new int[firstRows][firstCols];


        for (int i = 0; i < firstRows; i++) {
            String[] firstDataMatrix = scanner.nextLine().split("\\s+");
            for (int j = 0; j < firstCols; j++) {
                firstMatrix[i][j] = Integer.parseInt(firstDataMatrix[j]);
            }
        }

        parameters = scanner.nextLine().split("\\s+");

        int secondRows = Integer.parseInt(parameters[0]);
        int secondCols = Integer.parseInt(parameters[1]);

        int[][] secondMatrix = new int[secondRows][secondCols];

        for (int i = 0; i < secondRows; i++) {
            String[] secondDataMatrix = scanner.nextLine().split("\\s+");

            for (int j = 0; j < secondCols; j++) {
                secondMatrix[i][j] = Integer.parseInt(secondDataMatrix[j]);
            }
        }

        if (firstRows != secondRows || firstCols != secondCols) {
            System.out.println("not equal");
            return;
        } else {
            for (int i = 0; i < firstRows; i++) {
                for (int j = 0; j < firstCols; j++) {
                    if (firstMatrix[i][j] != secondMatrix[i][j]) {
                        System.out.println("not equal");
                        return;
                    }
                }
            }
        }

        System.out.println("equal");

    }
}
