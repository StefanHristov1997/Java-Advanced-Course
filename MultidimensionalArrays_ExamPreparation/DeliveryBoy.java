package MultidimensionalArrays_ExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class DeliveryBoy {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        char[][] roadMatrix = new char[rows][cols];

        fillMatrix(roadMatrix, scanner);
        int boyRow = boyRow(roadMatrix);
        int boyCol = boyCol(roadMatrix);
        int startBoyRow = boyRow;
        int startBoyCol = boyCol;
        roadMatrix[boyRow][boyCol] = '.';

        boolean end = true;

        while (end) {
            String directions = scanner.nextLine();


            if (directions.isEmpty()) {
                end = false;
                break;
            }

            switch (directions) {
                case "up":
                    if (checkIndex(roadMatrix, boyRow - 1, boyCol)) {
                        if (roadMatrix[boyRow - 1][boyCol] == 'P') {
                            roadMatrix[boyRow - 1][boyCol] = 'R';
                            System.out.println("Pizza is collected. 10 minutes for delivery.");
                            boyRow--;
                        } else if (roadMatrix[boyRow - 1][boyCol] == '*') {
                            continue;
                        } else if (roadMatrix[boyRow - 1][boyCol] == '-') {
                            roadMatrix[boyRow - 1][boyCol] = '.';
                            boyRow--;
                        } else if (roadMatrix[boyRow - 1][boyCol] == 'A') {
                            if (!checkFirstTask(roadMatrix)) {
                                end = false;
                                break;
                            }
                            roadMatrix[boyRow - 1][boyCol] = 'P';
                            System.out.println("Pizza is delivered on time! Next order...");
                            roadMatrix[startBoyRow][startBoyCol] = 'B';
                            end = false;
                            break;
                        } else if (roadMatrix[boyRow - 1][boyCol] == '.') {
                            boyRow--;
                        }
                    } else {
                        System.out.println("The delivery is late. Order is canceled.");
                        roadMatrix[startBoyRow][startBoyCol] = ' ';
                        end = false;
                        break;
                    }
                    break;
                case "down":
                    if (checkIndex(roadMatrix, boyRow + 1, boyCol)) {
                        if (roadMatrix[boyRow + 1][boyCol] == 'P') {
                            roadMatrix[boyRow + 1][boyCol] = 'R';
                            boyRow++;
                            System.out.println("Pizza is collected. 10 minutes for delivery.");
                        } else if (roadMatrix[boyRow + 1][boyCol] == '*') {
                            continue;
                        } else if (roadMatrix[boyRow + 1][boyCol] == '-') {
                            roadMatrix[boyRow + 1][boyCol] = '.';
                            boyRow++;
                        } else if (roadMatrix[boyRow + 1][boyCol] == 'A') {
                            if (!checkFirstTask(roadMatrix)) {
                                end = false;
                                break;
                            }
                            roadMatrix[boyRow + 1][boyCol] = 'P';
                            System.out.println("Pizza is delivered on time! Next order...");
                            roadMatrix[startBoyRow][startBoyCol] = 'B';
                            end = false;
                            break;
                        } else if (roadMatrix[boyRow + 1][boyCol] == '.') {
                            boyRow++;
                        }
                    } else {
                        System.out.println("The delivery is late. Order is canceled.");
                        roadMatrix[startBoyRow][startBoyCol] = ' ';
                        end = false;
                        break;
                    }
                    break;
                case "right":
                    if (checkIndex(roadMatrix, boyRow, boyCol + 1)) {
                        if (roadMatrix[boyRow][boyCol + 1] == 'P') {
                            roadMatrix[boyRow][boyCol + 1] = 'R';
                            boyCol++;
                            System.out.println("Pizza is collected. 10 minutes for delivery.");
                        } else if (roadMatrix[boyRow][boyCol + 1] == '*') {
                            continue;
                        } else if (roadMatrix[boyRow][boyCol + 1] == '-') {
                            roadMatrix[boyRow][boyCol + 1] = '.';
                            boyCol++;
                        } else if (roadMatrix[boyRow][boyCol + 1] == 'A') {
                            if (!checkFirstTask(roadMatrix)) {
                                end = false;
                                break;
                            }
                            roadMatrix[boyRow][boyCol + 1] = 'P';
                            System.out.println("Pizza is delivered on time! Next order...");
                            roadMatrix[startBoyRow][startBoyCol] = 'B';
                            end = false;
                            break;
                        } else if (roadMatrix[boyRow][boyCol + 1] == '.') {
                            boyCol++;
                        }
                    } else {
                        System.out.println("The delivery is late. Order is canceled.");
                        roadMatrix[startBoyRow][startBoyCol] = ' ';
                        end = false;
                        break;
                    }
                    break;
                case "left":
                    if (checkIndex(roadMatrix, boyRow, boyCol - 1)) {
                        if (roadMatrix[boyRow][boyCol - 1] == 'P') {
                            roadMatrix[boyRow][boyCol - 1] = 'R';
                            boyCol--;
                            System.out.println("Pizza is collected. 10 minutes for delivery.");
                        } else if (roadMatrix[boyRow][boyCol - 1] == '*') {
                            continue;
                        } else if (roadMatrix[boyRow][boyCol - 1] == '-') {
                            roadMatrix[boyRow][boyCol - 1] = '.';
                            boyCol--;
                        } else if (roadMatrix[boyRow][boyCol - 1] == 'A') {
                            if (!checkFirstTask(roadMatrix)) {
                                end = false;
                                break;
                            }
                            roadMatrix[boyRow][boyCol - 1] = 'P';
                            System.out.println("Pizza is delivered on time! Next order...");
                            roadMatrix[startBoyRow][startBoyCol] = 'B';
                            end = false;
                            break;
                        } else if (roadMatrix[boyRow][boyCol - 1] == '.') {
                            boyCol--;
                        }
                    } else {
                        System.out.println("The delivery is late. Order is canceled.");
                        roadMatrix[startBoyRow][startBoyCol] = ' ';
                        end = false;
                        break;
                    }
                    break;
            }

        }
        printMatrix(roadMatrix);

    }

    public static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String text = scanner.nextLine();
            char[] charArray = text.toCharArray();
            matrix[row] = charArray;
        }
    }

    public static void printMatrix(char[][] matrix) {

        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    public static boolean checkIndex(char[][] matrix, int rows, int cols) {
        return rows >= 0 && rows < matrix.length
                && cols >= 0 && cols < matrix[rows].length;
    }

    public static int boyRow(char[][] matrix) {
        int deliveryBoyRow = 0;

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'B') {
                    deliveryBoyRow = row;
                }
            }
        }

        return deliveryBoyRow;
    }

    public static int boyCol(char[][] matrix) {
        int deliveryBoyCol = 0;

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'B') {
                    deliveryBoyCol = col;
                }
            }
        }

        return deliveryBoyCol;
    }

    public static boolean checkFirstTask(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                if (aChar == 'R') {
                    return true;
                }
            }
        }
        return false;
    }
}
