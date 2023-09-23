package MultidimensionalArrays_Exercise_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation_06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] rotation = scanner.nextLine().split("\\(")[1].split("\\)");
        int rotationAngle = Integer.parseInt(rotation[0]) % 360;

        String input = scanner.nextLine();
        List<String> words = new ArrayList<>();
        int maxLength = Integer.MIN_VALUE;

        while (!"END".equals(input)) {
            words.add(input);

            if (input.length() > maxLength) {
                maxLength = input.length();
            }

            input = scanner.nextLine();
        }
        int rows = words.size();
        int cols = maxLength;

        char[][] matrix = new char[rows][cols];

        fillMatrix(matrix, words);
        rotate(rotationAngle, rows, cols, matrix);
    }

    private static void rotate(int angleRotation, int rows, int cols, char[][] matrix) {
        if (angleRotation == 90) {
            for (int col = 0; col < cols; col++) {
                for (int row = rows - 1; row >= 0; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }

        } else if (angleRotation == 180) {
            for (int row = rows - 1; row >= 0; row--) {
                for (int col = cols - 1; col >= 0; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (angleRotation == 270) {
            for (int col = cols - 1; col >= 0; col--) {
                for (int row = 0; row < rows; row++) {
                    System.out.print(matrix[row][col]);

                }
                System.out.println();
            }
        } else {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }
    }

    private static void fillMatrix(char[][] matrix, List<String> words) {

        for (int row = 0; row < matrix.length; row++) {
            String currentWord = words.get(row);
            for (int col = 0; col < matrix[row].length; col++) {
                if (col < currentWord.length()) {
                    matrix[row][col] = currentWord.charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
    }

    private static void printMatrix(char[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
