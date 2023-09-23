package MultidimensionalArrays_Exercise_02;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        int rightDiagonal = 0;

        for (int row = 0; row < matrix.length; row++) {
            int[] dataForMatrix = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = dataForMatrix[column];

                if (row == column) {
                    rightDiagonal += matrix[row][column];
                }
            }
        }
        int leftDiagonal = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {

                if (row + column == matrix.length - 1) {
                    leftDiagonal += matrix[row][column];
                }
            }
        }

        System.out.println(Math.abs(rightDiagonal - leftDiagonal));

    }

}
