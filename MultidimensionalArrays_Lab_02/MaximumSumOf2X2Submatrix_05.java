package MultidimensionalArrays_Lab_02;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2X2Submatrix_05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] rowsAndColumns = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        int rows = rowsAndColumns[0];
        int columns = rowsAndColumns[1];

        int[][] matrix = new int[rows][columns];


        for (int row = 0; row < matrix.length; row++) {
            int[] dataForColumns = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = dataForColumns[column];
            }
        }


        int sumOfElements = 0;
        int maxSum = Integer.MIN_VALUE;
        int maxFirstRowNumber = 0;
        int maxFirstColumnNumber = 0;
        int maxSecondRowNumber = 0;
        int maxSecondColumnNumber = 0;

        for (int row = 0; row < matrix.length - 1; row++) {

            for (int column = 0; column < matrix[row].length - 1; column++) {
                sumOfElements = matrix[row][column] + matrix[row][column + 1] +
                        matrix[row + 1][column] + matrix[row + 1][column + 1];


                if (sumOfElements > maxSum) {
                    maxSum = sumOfElements;

                    maxFirstRowNumber = matrix[row][column];
                    maxFirstColumnNumber = matrix[row][column + 1];
                    maxSecondRowNumber = matrix[row + 1][column];
                    maxSecondColumnNumber = matrix[row + 1][column + 1];
                }
            }

        }

        System.out.println(maxFirstRowNumber + " " + maxFirstColumnNumber);
        System.out.println(maxSecondRowNumber + " " + maxSecondColumnNumber);
        System.out.println(maxSum);

    }
}
