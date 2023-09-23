package MultidimensionalArrays_Exercise_02;

import java.util.Scanner;

public class FillTheMatrix_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int n = Integer.parseInt(input[0]);

        String pattern = input[1];

        switch (pattern) {
            case "A":
                int[][] matrixA = patternA(n);
                printMatrix(matrixA);
                break;
            case "B":
                int[][] matrixB = patternB(n);
                printMatrix(matrixB);
                break;
        }


    }

    public static int[][] patternA(int n) {

        int[][] matrix = new int[n][n];

        int startArray = 1;
        int column = 0;

        while (n > 0) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][column] = startArray++;

            }
            column++;
            n--;
        }


        return matrix;

    }

    public static int[][] patternB(int n) {
        int[][] matrix = new int[n][n];

        int startArray = 1;
        int column = 0;

        while (n > 0) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][column] = startArray++;
            }

            if (n <= 1) {
                break;
            }

            column++;
            n--;

            for (int row = matrix.length - 1; row >= 0; row--) {
                matrix[row][column] = startArray++;
            }

            n--;
            column++;
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
