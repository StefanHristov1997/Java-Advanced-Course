package MultidimensionalArrays_Exercise_02;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals_11 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = arr(scanner);
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = new int[rows][cols];
        fillMatrix(matrix, scanner);

        for (int row = matrix.length - 1; row >= 0; row--) {

            for (int col = matrix.length - 1; col >= 0; col--) {
                if (col != matrix.length - 1){
                    System.out.print(matrix[row][col] + " ");
                    System.out.print((matrix[row -1][col + 1]));

                    if((matrix[row -1][col + 1]) != matrix.length - 1){
                        System.out.print((matrix[row -1][col + 2]));
                    }
                    System.out.println();
                }else{
                    System.out.print(matrix[row][col] + " ");
                    System.out.println();
                }
            }
        }
    }

    private static boolean isValid(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 &&
                col < matrix[row].length;
    }

    private static int[] arr(Scanner scanner) {
        int[] array = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        return array;
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            int[] array = arr(scanner);
            matrix[row] = array;
        }
    }
}
