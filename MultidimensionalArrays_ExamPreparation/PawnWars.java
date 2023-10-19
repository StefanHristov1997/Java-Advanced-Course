package MultidimensionalArrays_ExamPreparation;

import java.util.Scanner;

public class PawnWars {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[][] chessboard = new char[8][8];

        fillMatrix(scanner, chessboard);
        int rowCoordinateBlack = rowCoordinatesBlack(chessboard);
        int colCoordinateBlack = colCoordinatesBlack(chessboard);

        int rowCoordinateWhite = rowCoordinatesWhite(chessboard);
        int colCoordinateWhite = colCoordinatesWhite(chessboard);

        boolean whiteWin = false;
        boolean blackWin = false;

        boolean whiteCapture = false;
        boolean blackCapture = false;

        for (int rowWhite = 1; rowWhite <= 8; rowWhite++) {

            if (checkIndex(chessboard, rowCoordinateWhite - 1, colCoordinateWhite - 1)) {
                if (chessboard[rowCoordinateWhite - 1][colCoordinateWhite - 1] == 'b') {
                    whiteCapture = true;
                    break;
                }
            }

            if (checkIndex(chessboard, rowCoordinateWhite - 1, colCoordinateWhite + 1)) {
                if (chessboard[rowCoordinateWhite - 1][colCoordinateWhite + 1] == 'b') {
                    whiteCapture = true;
                    break;
                }
            }
            chessboard[rowCoordinateWhite - 1][colCoordinateWhite] = 'w';
            chessboard[rowCoordinateWhite][colCoordinateWhite] = '-';
            rowCoordinateWhite--;

            if (rowCoordinateWhite == 0) {
                whiteWin = true;
                break;
            }

            if (checkIndex(chessboard, rowCoordinateBlack + 1, colCoordinateBlack - 1)) {
                if (chessboard[rowCoordinateBlack + 1][colCoordinateBlack - 1] == 'w') {
                    blackCapture = true;
                    break;
                }
            }

            if (checkIndex(chessboard, rowCoordinateBlack + 1, colCoordinateBlack + 1)) {
                if (chessboard[rowCoordinateBlack + 1][colCoordinateBlack + 1] == 'w') {
                    blackCapture = true;
                    break;
                }
            }

            chessboard[rowCoordinateBlack + 1][colCoordinateBlack] = 'b';
            chessboard[rowCoordinateBlack][colCoordinateBlack] = '-';
            rowCoordinateBlack++;

            if (rowCoordinateBlack == 7) {
                blackWin = true;
                break;
            }

        }

        if (whiteCapture) {
            if (colCoordinateBlack == 0) {
                colCoordinateBlack = 'a';
            } else if (colCoordinateBlack == 1) {
                colCoordinateBlack = 'b';
            } else if (colCoordinateBlack == 2) {
                colCoordinateBlack = 'c';
            } else if (colCoordinateBlack == 3) {
                colCoordinateBlack = 'd';
            } else if (colCoordinateBlack == 4) {
                colCoordinateBlack = 'e';
            } else if (colCoordinateBlack == 5) {
                colCoordinateBlack = 'f';
            } else if (colCoordinateBlack == 6) {
                colCoordinateBlack = 'g';
            } else if (colCoordinateBlack == 7) {
                colCoordinateBlack = 'h';
            }

            System.out.printf("Game over! White capture on %c%d.", colCoordinateBlack, chessboard.length - rowCoordinateBlack);
            return;
        } else if (blackCapture) {
            if (colCoordinateWhite == 0) {
                colCoordinateWhite = 'a';
            } else if (colCoordinateWhite == 1) {
                colCoordinateWhite = 'b';
            } else if (colCoordinateWhite == 2) {
                colCoordinateWhite = 'c';
            } else if (colCoordinateWhite == 3) {
                colCoordinateWhite = 'd';
            } else if (colCoordinateWhite == 4) {
                colCoordinateWhite = 'e';
            } else if (colCoordinateWhite == 5) {
                colCoordinateWhite = 'f';
            } else if (colCoordinateWhite == 6) {
                colCoordinateWhite = 'g';
            } else if (colCoordinateWhite == 7) {
                colCoordinateWhite = 'h';
            }
            System.out.printf("Game over! Black capture on %c%d.", colCoordinateWhite, chessboard.length - rowCoordinateWhite);
            return;
        }

        if (whiteWin) {
            if (colCoordinateWhite == 0) {
                colCoordinateWhite = 'a';
            } else if (colCoordinateWhite == 1) {
                colCoordinateWhite = 'b';
            } else if (colCoordinateWhite == 2) {
                colCoordinateWhite = 'c';
            } else if (colCoordinateWhite == 3) {
                colCoordinateWhite = 'd';
            } else if (colCoordinateWhite == 4) {
                colCoordinateWhite = 'e';
            } else if (colCoordinateWhite == 5) {
                colCoordinateWhite = 'f';
            } else if (colCoordinateWhite == 6) {
                colCoordinateWhite = 'g';
            } else if (colCoordinateWhite == 7) {
                colCoordinateWhite = 'h';
            }
            System.out.printf("Game over! White pawn is promoted to a queen at %c8.\n", colCoordinateWhite);
        } else if (blackWin) {
            if (colCoordinateBlack == 0) {
                colCoordinateBlack = 'a';
            } else if (colCoordinateBlack == 1) {
                colCoordinateBlack = 'b';
            } else if (colCoordinateBlack == 2) {
                colCoordinateBlack = 'c';
            } else if (colCoordinateBlack == 3) {
                colCoordinateBlack = 'd';
            } else if (colCoordinateBlack == 4) {
                colCoordinateBlack = 'e';
            } else if (colCoordinateBlack == 5) {
                colCoordinateBlack = 'f';
            } else if (colCoordinateBlack == 6) {
                colCoordinateBlack = 'g';
            } else if (colCoordinateBlack == 7) {
                colCoordinateBlack = 'h';
            }
            System.out.printf("Game over! Black pawn is promoted to a queen at %c1.\n", colCoordinateBlack);
        }
    }

    public static void fillMatrix(Scanner scanner, char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }
    }

    public static int rowCoordinatesBlack(char[][] matrix) {
        int coordinate = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'b') {
                    coordinate = row;
                    break;
                }
            }
        }
        return coordinate;
    }

    public static int colCoordinatesBlack(char[][] matrix) {
        int coordinate = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'b') {
                    coordinate = col;
                    break;
                }
            }
        }
        return coordinate;
    }

    public static int colCoordinatesWhite(char[][] matrix) {
        int coordinate = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'w') {
                    coordinate = col;
                    break;
                }
            }
        }
        return coordinate;
    }

    public static int rowCoordinatesWhite(char[][] matrix) {
        int coordinate = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'w') {
                    coordinate = row;
                    break;
                }
            }
        }
        return coordinate;
    }

    public static boolean checkIndex(char[][] matrix, int row, int cols) {
        return row >= 0 && row < matrix.length && cols >= 0 && cols < matrix[row].length;
    }

}
