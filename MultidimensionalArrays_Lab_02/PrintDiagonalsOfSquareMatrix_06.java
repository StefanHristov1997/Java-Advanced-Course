package MultidimensionalArrays_Lab_02;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix_06 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int sides = Integer.parseInt(scanner.nextLine());

        int[][] table = new int[sides][sides];


        for (int row = 0; row < table.length; row++) {
            int[] tableData = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt((Integer::parseInt)).toArray();

            for (int column = 0; column < table[row].length; column++) {
                table[row][column] = tableData[column];
            }
        }


        for (int row = 0; row < table.length; row++) {

            for (int column = 0; column < table[row].length; column++) {

                if (row == column) {
                    System.out.print(table[row][column] + " ");
                }

            }
        }

        System.out.println();

        int match = sides - 1;

        for (int row = table.length - 1; row >= 0; row--) {

            for (int column = 0; column < table[row].length; column++) {

                if (row + column == match) {
                    System.out.print(table[row][column] + " ");
                }

            }
        }

    }
}
