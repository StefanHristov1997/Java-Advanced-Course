package MultidimensionalArrays_Exercise_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire_07 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] input = readArr(scanner);

        List<List<Integer>> matrix = new ArrayList<>();

        fillMatrix(matrix, input[0], input[1]);

        String command = scanner.nextLine();

        while (!command.equals("Nuke it from orbit")) {
            int[] data = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int targetRow = data[0];
            int targetCol = data[1];
            int radius = data[2];

            for (int row = targetRow - radius; row <= targetRow + radius; row++) {
                if (isValidIndex(matrix, row, targetCol)) {
                    matrix.get(row).set(targetCol, 0);
                }
            }

            for (int col = targetCol - radius; col <= targetCol + radius; col++) {
                if (isValidIndex(matrix, targetRow, col)) {
                    matrix.get(targetRow).set(col, 0);
                }

            }


            for (int row = 0; row < matrix.size(); row++) {
                matrix.get(row).removeAll(List.of(0));

                if (matrix.get(row).isEmpty()) {
                    matrix.remove(row);
                    row--;
                }
            }


            command = scanner.nextLine();
        }

        printMatrix(matrix);

    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            row.forEach(e -> System.out.print(e + " "));
            System.out.println();
        }
    }

    private static void fillMatrix(List<List<Integer>> matrix, int r, int c) {
        int start = 1;
        for (int row = 0; row < r; row++) {
            List<Integer> numbers = new ArrayList<>();
            for (int col = 0; col < c; col++) {
                numbers.add(start++);
            }
            matrix.add(numbers);
        }

    }

    private static boolean isValidIndex(List<List<Integer>> matrix, int r, int c) {

        return r >= 0 && r < matrix.size() &&
                c >= 0 && c < matrix.get(r).size();
    }

    private static int[] readArr(Scanner scanner) {
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        return arr;
    }
}
