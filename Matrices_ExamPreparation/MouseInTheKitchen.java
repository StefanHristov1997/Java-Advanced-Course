package Matrices_ExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class MouseInTheKitchen {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];
        char[][] cupboard = new char[rows][cols];
        fillMatrix(cupboard, scanner);
        int mouseRow = mouseRow(cupboard);
        int mouseCol = mouseCol(cupboard);

        String command = scanner.nextLine();

        while (!command.equals("danger")) {
            boolean mouseStepOutside = false;
            boolean mouseIsTrapped = false;
            switch (command) {
                case "up":
                    if (!isOutside(cupboard, mouseRow - 1, mouseCol)) {
                        System.out.println("No more cheese for tonight!");
                        mouseStepOutside = true;
                        break;
                    } else {
                        if (cupboard[mouseRow - 1][mouseCol] == '*') {
                            cupboard[mouseRow - 1][mouseCol] = 'M';
                            cupboard[mouseRow][mouseCol] = '*';
                            mouseRow -= 1;
                        } else if (cupboard[mouseRow - 1][mouseCol] == '@') {
                            command = scanner.nextLine();
                            continue;
                        } else if (cupboard[mouseRow - 1][mouseCol] == 'C') {
                            cupboard[mouseRow - 1][mouseCol] = 'M';
                            cupboard[mouseRow][mouseCol] = '*';
                            mouseRow -= 1;

                            if (isLastCheese(cupboard)) {
                                System.out.println("Happy mouse! All the cheese is eaten, good night!");
                            }
                        } else if (cupboard[mouseRow - 1][mouseCol] == 'T') {
                            cupboard[mouseRow - 1][mouseCol] = 'M';
                            cupboard[mouseRow][mouseCol] = '*';
                            System.out.println("Mouse is trapped!");
                            mouseIsTrapped = true;
                            break;
                        }
                    }
                    break;
                case "down":
                    if (!isOutside(cupboard, mouseRow + 1, mouseCol)) {
                        System.out.println("No more cheese for tonight!");
                        mouseStepOutside = true;
                        break;
                    } else {
                        if (cupboard[mouseRow + 1][mouseCol] == '*') {
                            cupboard[mouseRow + 1][mouseCol] = 'M';
                            cupboard[mouseRow][mouseCol] = '*';
                            mouseRow += 1;
                        } else if (cupboard[mouseRow + 1][mouseCol] == '@') {
                            command = scanner.nextLine();
                            continue;
                        } else if (cupboard[mouseRow + 1][mouseCol] == 'C') {
                            cupboard[mouseRow + 1][mouseCol] = 'M';
                            cupboard[mouseRow][mouseCol] = '*';
                            mouseRow += 1;

                            if (isLastCheese(cupboard)) {
                                System.out.println("Happy mouse! All the cheese is eaten, good night!");
                                break;
                            }
                        } else if (cupboard[mouseRow + 1][mouseCol] == 'T') {
                            cupboard[mouseRow + 1][mouseCol] = 'M';
                            cupboard[mouseRow][mouseCol] = '*';
                            System.out.println("Mouse is trapped!");
                            mouseIsTrapped = true;
                            break;
                        }
                    }
                    break;
                case "right":
                    if (!isOutside(cupboard, mouseRow, mouseCol + 1)) {
                        System.out.println("No more cheese for tonight!");
                        mouseStepOutside = true;
                        break;
                    } else {
                        if (cupboard[mouseRow][mouseCol + 1] == '*') {
                            cupboard[mouseRow][mouseCol + 1] = 'M';
                            cupboard[mouseRow][mouseCol] = '*';
                            mouseCol += 1;
                        } else if (cupboard[mouseRow][mouseCol + 1] == '@') {
                            command = scanner.nextLine();
                            continue;
                        } else if (cupboard[mouseRow][mouseCol + 1] == 'C') {
                            cupboard[mouseRow][mouseCol + 1] = 'M';
                            cupboard[mouseRow][mouseCol] = '*';
                            mouseCol += 1;

                            if (isLastCheese(cupboard)) {
                                System.out.println("Happy mouse! All the cheese is eaten, good night!");
                                break;
                            }
                        } else if (cupboard[mouseRow][mouseCol + 1] == 'T') {
                            cupboard[mouseRow][mouseCol + 1] = 'M';
                            cupboard[mouseRow][mouseCol] = '*';
                            System.out.println("Mouse is trapped!");
                            mouseIsTrapped = true;
                            break;
                        }
                    }
                    break;
                case "left":
                    if (!isOutside(cupboard, mouseRow, mouseCol - 1)) {
                        System.out.println("No more cheese for tonight!");
                        mouseStepOutside = true;
                        break;
                    } else {
                        if (cupboard[mouseRow][mouseCol - 1] == '*') {
                            cupboard[mouseRow][mouseCol - 1] = 'M';
                            cupboard[mouseRow][mouseCol] = '*';
                            mouseCol -= 1;
                        } else if (cupboard[mouseRow][mouseCol - 1] == '@') {
                            command = scanner.nextLine();
                            continue;
                        } else if (cupboard[mouseRow][mouseCol - 1] == 'C') {
                            cupboard[mouseRow][mouseCol - 1] = 'M';
                            cupboard[mouseRow][mouseCol] = '*';
                            mouseCol -= 1;
                            if (isLastCheese(cupboard)) {
                                System.out.println("Happy mouse! All the cheese is eaten, good night!");
                                break;
                            }
                        } else if (cupboard[mouseRow][mouseCol - 1] == 'T') {
                            cupboard[mouseRow][mouseCol - 1] = 'M';
                            cupboard[mouseRow][mouseCol] = '*';
                            System.out.println("Mouse is trapped!");
                            mouseIsTrapped = true;
                            break;
                        }
                    }
                    break;

            }

            if (mouseStepOutside) {
                printMatrix(cupboard);
                return;
            }

            if (isLastCheese(cupboard)) {
                printMatrix(cupboard);
                return;
            }
            if (mouseIsTrapped) {
                printMatrix(cupboard);
                return;
            }
            command = scanner.nextLine();
        }


        System.out.println("Mouse will come back later!");
        printMatrix(cupboard);
    }

    public static void printMatrix(char[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    public static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String text = scanner.nextLine();
            char[] charArray = text.toCharArray();
            matrix[row] = charArray;
        }
    }

    public static boolean isOutside(char[][] matrix, int row, int cols) {
        return row >= 0 && row < matrix.length && cols >= 0 && cols < matrix[row].length;
    }

    public static int mouseRow(char[][] matrix) {
        int mouseRow = 0;

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'M') {
                    mouseRow = row;
                }
            }
        }

        return mouseRow;
    }

    public static int mouseCol(char[][] matrix) {
        int mouseCol = 0;

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'M') {
                    mouseCol = col;
                }
            }
        }

        return mouseCol;
    }

    public static boolean isLastCheese(char[][] matrix) {
        boolean isItLastCheese = true;

        for (char[] chars : matrix) {
            for (char aChar : chars) {
                if (aChar == 'C') {
                    isItLastCheese = false;
                    break;
                }
            }
        }
        return isItLastCheese;
    }
}
