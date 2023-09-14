package MultidimensionalArrays_Lab_02;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] rowsAndColumns = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        System.out.println(rowsAndColumns[0]);
        System.out.println(rowsAndColumns[1]);

        int[][] matrix = new int[rowsAndColumns[0]][rowsAndColumns[1]];

        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            int[] matrixColumnData = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();

            for (int column = 0; column < matrix[row].length; column++) {
                //matrix[row][column] = matrixColumnData[column];
                sum += matrixColumnData[column];
            }
        }

        System.out.println(sum);
    }
}
