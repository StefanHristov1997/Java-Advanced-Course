package MultidimensionalArrays_Lab_02;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] rowAndCols = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = rowAndCols[0];
        int columns = rowAndCols[1];

        int[][] matrix = new int[rows][columns];

        for (int row = 0; row < matrix.length; row++) {
            int[] columnsData = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = columnsData[column];
            }
        }

        int number = Integer.parseInt(scanner.nextLine());

        boolean isFound = false;

        for (int row = 0; row < matrix.length; row++) {

            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == number) {
                    System.out.println(row + " " + column);
                    isFound = true;
                }
            }
        }

        if (!isFound) {
            System.out.println("not found");
        }
    }
}
