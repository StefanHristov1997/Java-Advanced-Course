package MultidimensionalArrays_Exercise_02;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum_04 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int rows = rowsAndCols[0];
        int columns = rowsAndCols[1];

        int[][] matrix = new int[rows][columns];

        for (int row = 0; row < matrix.length; row++) {

            int[] data = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int column = 0; column < matrix[row].length; column++) {

                matrix[row][column] = data[column];
            }
        }

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        int element0 = 0;
        int element1 = 0;
        int element2 = 0;
        int element3 = 0;
        int element4 = 0;
        int element5 = 0;
        int element6 = 0;
        int element7 = 0;
        int element8 = 0;


        for (int row = 0; row < matrix.length - 2; row++) {

            for (int column = 0; column < matrix[row].length - 2; column++) {

                sum = matrix[row][column] + matrix[row][column + 1] + matrix[row][column + 2]
                        + matrix[row + 1][column] + matrix[row + 1][column + 1] + matrix[row + 1][column + 2]
                        + matrix[row + 2][column] + matrix[row + 2][column + 1] + matrix[row + 2][column + 2];

                if (sum > maxSum) {
                    maxSum = sum;


                    element0 = matrix[row][column];
                    element1 = matrix[row][column + 1];
                    element2 = matrix[row][column + 2];
                    element3 = matrix[row + 1][column];
                    element4 = matrix[row + 1][column + 1];
                    element5 = matrix[row + 1][column + 2];
                    element6 = matrix[row + 2][column];
                    element7 = matrix[row + 2][column + 1];
                    element8 = matrix[row + 2][column + 2];

                }
            }
        }

        System.out.println("Sum = " + maxSum);

        System.out.print(element0 + " " + element1 + " " + element2);
        System.out.println();
        System.out.print(element3 + " " + element4 + " " + element5);
        System.out.println();
        System.out.print(element6 + " " + element7 + " " + element8);


    }
}
