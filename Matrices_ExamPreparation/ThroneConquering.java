package Matrices_ExamPreparation;

import java.util.Scanner;

public class ThroneConquering {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int parisEnergy = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());
        char[][] battleField = new char[rows][];
        fillMatrix(battleField, scanner);

        int parisRow = parisRow(battleField);
        int parisCol = parisCol(battleField);

        while (parisEnergy > 0) {
            String[] command = scanner.nextLine().split("\\s+");
            String commandPart = command[0];
            switch (commandPart) {
                case "up":
                    int enemyRow = Integer.parseInt(command[1]);
                    int enemyCol = Integer.parseInt(command[2]);
                    parisEnergy -= 1;

                    battleField[enemyRow][enemyCol] = 'S';

                    if (checkIndex(battleField, parisRow - 1, parisCol)) {
                        if (battleField[parisRow - 1][parisCol] == 'S') {
                            parisEnergy -= 2;
                            if (parisEnergy <= 0) {
                                battleField[parisRow - 1][parisCol] = 'X';
                                battleField[parisRow][parisCol] = '-';
                                parisRow--;
                                System.out.printf("Paris died at %d;%d.\n", parisRow, parisCol);
                                printMatrix(battleField);
                                return;
                            }
                            battleField[parisRow - 1][parisCol] = 'P';
                            battleField[parisRow][parisCol] = '-';
                            parisRow--;
                        } else if (battleField[parisRow - 1][parisCol] == 'H') {
                            battleField[parisRow][parisCol] = '-';
                            battleField[parisRow - 1][parisCol] = '-';
                            System.out.println("Paris has successfully abducted Helen! Energy left: " + parisEnergy);
                            printMatrix(battleField);
                            return;
                        } else {
                            if (parisEnergy <= 0) {
                                battleField[parisRow - 1][parisCol] = 'X';
                                battleField[parisRow][parisCol] = '-';
                                parisRow--;
                                System.out.printf("Paris died at %d;%d.\n", parisRow, parisCol);
                                printMatrix(battleField);
                                return;
                            }
                            battleField[parisRow - 1][parisCol] = 'P';
                            battleField[parisRow][parisCol] = '-';
                            parisRow--;
                        }
                    }
                    break;
                case "down":
                    int enemyRowDown = Integer.parseInt(command[1]);
                    int enemyColDown = Integer.parseInt(command[2]);
                    parisEnergy -= 1;

                    battleField[enemyRowDown][enemyColDown] = 'S';

                    if (checkIndex(battleField, parisRow + 1, parisCol)) {
                        if (battleField[parisRow + 1][parisCol] == 'S') {
                            parisEnergy -= 2;
                            if (parisEnergy <= 0) {
                                battleField[parisRow + 1][parisCol] = 'X';
                                battleField[parisRow][parisCol] = '-';
                                parisRow++;
                                System.out.printf("Paris died at %d;%d.\n", parisRow, parisCol);
                                printMatrix(battleField);
                                return;
                            }
                            battleField[parisRow + 1][parisCol] = 'P';
                            battleField[parisRow][parisCol] = '-';
                            parisRow++;
                        } else if (battleField[parisRow + 1][parisCol] == 'H') {
                            battleField[parisRow][parisCol] = '-';
                            battleField[parisRow + 1][parisCol] = '-';
                            System.out.println("Paris has successfully abducted Helen! Energy left: " + parisEnergy);
                            printMatrix(battleField);
                            return;
                        } else {
                            if (parisEnergy <= 0) {
                                battleField[parisRow + 1][parisCol] = 'X';
                                battleField[parisRow][parisCol] = '-';
                                parisRow++;
                                System.out.printf("Paris died at %d;%d.\n", parisRow, parisCol);
                                printMatrix(battleField);
                                return;
                            }
                            battleField[parisRow + 1][parisCol] = 'P';
                            battleField[parisRow][parisCol] = '-';
                            parisRow++;
                        }
                    }
                    break;
                case "left":
                    int enemyRowLeft = Integer.parseInt(command[1]);
                    int enemyColLeft = Integer.parseInt(command[2]);
                    parisEnergy -= 1;

                    battleField[enemyRowLeft][enemyColLeft] = 'S';

                    if (checkIndex(battleField, parisRow, parisCol - 1)) {
                        if (battleField[parisRow][parisCol - 1] == 'S') {
                            parisEnergy -= 2;
                            if (parisEnergy <= 0) {
                                battleField[parisRow][parisCol - 1] = 'X';
                                battleField[parisRow][parisCol] = '-';
                                parisCol--;
                                System.out.printf("Paris died at %d;%d.\n", parisRow, parisCol);
                                printMatrix(battleField);
                                return;
                            }
                            battleField[parisRow][parisCol - 1] = 'P';
                            battleField[parisRow][parisCol] = '-';
                            parisCol--;
                        } else if (battleField[parisRow][parisCol - 1] == 'H') {
                            battleField[parisRow][parisCol] = '-';
                            battleField[parisRow][parisCol - 1] = '-';
                            System.out.println("Paris has successfully abducted Helen! Energy left: " + parisEnergy);
                            printMatrix(battleField);
                            return;
                        } else {
                            if (parisEnergy <= 0) {
                                battleField[parisRow][parisCol - 1] = 'X';
                                battleField[parisRow][parisCol] = '-';
                                parisCol--;
                                System.out.printf("Paris died at %d;%d.\n", parisRow, parisCol);
                                printMatrix(battleField);
                                return;
                            }
                            battleField[parisRow][parisCol - 1] = 'P';
                            battleField[parisRow][parisCol] = '-';
                            parisCol--;
                        }
                    }
                    break;
                case "right":
                    int enemyRowRight = Integer.parseInt(command[1]);
                    int enemyColRight = Integer.parseInt(command[2]);
                    parisEnergy -= 1;

                    battleField[enemyRowRight][enemyColRight] = 'S';

                    if (checkIndex(battleField, parisRow, parisCol + 1)) {
                        if (battleField[parisRow][parisCol + 1] == 'S') {
                            parisEnergy -= 2;
                            if (parisEnergy <= 0) {
                                battleField[parisRow][parisCol + 1] = 'X';
                                battleField[parisRow][parisCol] = '-';
                                parisCol++;
                                System.out.printf("Paris died at %d;%d.\n", parisRow, parisCol);
                                printMatrix(battleField);
                                return;
                            }
                            battleField[parisRow][parisCol + 1] = 'P';
                            battleField[parisRow][parisCol] = '-';
                            parisCol++;
                        } else if (battleField[parisRow][parisCol + 1] == 'H') {
                            battleField[parisRow][parisCol] = '-';
                            battleField[parisRow][parisCol + 1] = '-';
                            System.out.println("Paris has successfully abducted Helen! Energy left: " + parisEnergy);
                            printMatrix(battleField);
                            return;
                        } else {
                            if (parisEnergy <= 0) {
                                battleField[parisRow][parisCol + 1] = 'X';
                                battleField[parisRow][parisCol] = '-';
                                parisCol++;
                                System.out.printf("Paris died at %d;%d.\n", parisRow, parisCol);
                                printMatrix(battleField);
                                return;
                            }
                            battleField[parisRow][parisCol + 1] = 'P';
                            battleField[parisRow][parisCol] = '-';
                            parisCol++;
                        }
                    }
                    break;
            }

        }

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

    public static int parisRow(char[][] matrix) {
        int parisRow = 0;

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'P') {
                    parisRow = row;
                }
            }
        }

        return parisRow;
    }

    public static int parisCol(char[][] matrix) {
        int parisCol = 0;

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'P') {
                    parisCol = col;
                }
            }
        }
        return parisCol;

    }


}
