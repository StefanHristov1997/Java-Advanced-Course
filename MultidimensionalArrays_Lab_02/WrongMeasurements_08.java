package MultidimensionalArrays_Lab_02;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements_08 {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[] dataForMatrix = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();


        int[][] matrix = new int[rows][];

        for (int row = 0; row <= rows; row++) {
            dataForMatrix = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            for (int colunm = 0; colunm < dataForMatrix.length; colunm++) {
                matrix[row][colunm] = dataForMatrix[colunm];
            }


        }

        System.out.println();
    }
}
