package MultidimensionalArrays_ExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class BlindMansBuff {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        String[][] playground = new String[rows][cols];

        fillMatrix(playground,scanner);

        int blindMenRow = blindMenRow(playground);
        int blindMenCol = blindMenCol(playground);

        int touchedOpponents = 0;
        int movesMade = 0;

        String directions = scanner.nextLine();

        while (!directions.equals("Finish")){
            switch (directions){
                case "up":
                  if(checkIndex(playground, blindMenRow - 1, blindMenCol)){
                      if(playground[blindMenRow-1][blindMenCol].equals("O")){
                     directions = scanner.nextLine();
                     continue;
                       }else if(playground[blindMenRow - 1][blindMenCol].equals("-")){
                     movesMade++;
                     playground[blindMenRow - 1][blindMenCol] = "B";
                     playground[blindMenRow][blindMenCol] = "-";
                     blindMenRow--;
                      }else if (playground[blindMenRow - 1][blindMenCol].equals("P")){
                     movesMade++;
                     touchedOpponents++;
                     playground[blindMenRow - 1][blindMenCol] = "B";
                     playground[blindMenRow][blindMenCol] = "-";
                     blindMenRow--;
                 }
                 }else{
                    directions = scanner.nextLine();
                     continue;
             }
                    break;
                case "down":
                    if(checkIndex(playground, blindMenRow + 1, blindMenCol)){
                        if(playground[blindMenRow + 1][blindMenCol].equals("O")){
                            directions = scanner.nextLine();
                            continue;
                        }else if(playground[blindMenRow + 1][blindMenCol].equals("-")){
                            movesMade++;
                            playground[blindMenRow + 1][blindMenCol] = "B";
                            playground[blindMenRow][blindMenCol] = "-";
                            blindMenRow++;
                        }else if (playground[blindMenRow + 1][blindMenCol].equals("P")){
                            movesMade++;
                            touchedOpponents++;
                            playground[blindMenRow + 1][blindMenCol] = "B";
                            playground[blindMenRow][blindMenCol] = "-";
                            blindMenRow++;
                        }
                    }else{
                        directions = scanner.nextLine();
                        continue;
                    }
                    break;
                case "right":
                    if(checkIndex(playground, blindMenRow, blindMenCol + 1)){
                        if(playground[blindMenRow][blindMenCol + 1].equals("O")){
                            directions = scanner.nextLine();
                            continue;
                        }else if(playground[blindMenRow][blindMenCol + 1].equals("-")){
                            movesMade++;
                            playground[blindMenRow][blindMenCol + 1] = "B";
                            playground[blindMenRow][blindMenCol] = "-";
                            blindMenCol++;
                        }else if (playground[blindMenRow][blindMenCol + 1].equals("P")){
                            movesMade++;
                            touchedOpponents++;
                            playground[blindMenRow][blindMenCol + 1] = "B";
                            playground[blindMenRow][blindMenCol] = "-";
                            blindMenCol++;
                        }
                    }else{
                        directions = scanner.nextLine();
                        continue;
                    }
                    break;
                case "left":
                    if(checkIndex(playground, blindMenRow, blindMenCol - 1)){
                        if(playground[blindMenRow][blindMenCol - 1].equals("O")){
                            directions = scanner.nextLine();
                            continue;
                        }else if(playground[blindMenRow][blindMenCol - 1].equals("-")){
                            movesMade++;
                            playground[blindMenRow][blindMenCol - 1] = "B";
                            playground[blindMenRow][blindMenCol] = "-";
                            blindMenCol--;
                        }else if (playground[blindMenRow][blindMenCol - 1].equals("P")){
                            movesMade++;
                            touchedOpponents++;
                            playground[blindMenRow][blindMenCol - 1] = "B";
                            playground[blindMenRow][blindMenCol] = "-";
                            blindMenCol--;
                        }
                    }else{
                        directions = scanner.nextLine();
                        continue;
                    }
                    break;
            }

            if(touchedOpponents == 3){
                System.out.println("Game over!");
                System.out.printf("Touched opponents: %d Moves made: %d\n", touchedOpponents, movesMade);
                return;
            }

            directions = scanner.nextLine();
        }

        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d\n", touchedOpponents, movesMade);

    }
    public static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
    public static boolean checkIndex(String[][] matrix, int rows, int cols) {
        return rows >= 0 && rows < matrix.length
                && cols >= 0 && cols < matrix[rows].length;
    }

    public static int blindMenRow(String[][] matrix) {
        int blindMenRow = 0;

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("B")) {
                    blindMenRow = row;
                }
            }
        }

        return blindMenRow;
    }
    public static int blindMenCol(String[][] matrix) {
        int blindMenCol = 0;

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("B")) {
                    blindMenCol = col;
                }
            }
        }

        return blindMenCol;
    }

}
