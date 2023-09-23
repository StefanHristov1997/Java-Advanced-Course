package MultidimensionalArrays_Exercise_02;

import java.util.Scanner;

public class MatrixOfPalindromes_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] rowsAndColumns = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(rowsAndColumns[0]);
        int columns = Integer.parseInt(rowsAndColumns[1]);

        String[][] matrix = new String[rows][columns];


        for (int row = 0; row < matrix.length; row++) {

            for (int column = 0; column < matrix[row].length; column++) {
                String firstAndLastSymbol = String.valueOf((char) ('a' + row));
                String middleSymbol = String.valueOf((char) ('a' + row + column));
                matrix[row][column] = firstAndLastSymbol + middleSymbol + firstAndLastSymbol;
            }

        }

        printMatrix(matrix);

    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {

            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }

            System.out.println("");
        }
    }
}
