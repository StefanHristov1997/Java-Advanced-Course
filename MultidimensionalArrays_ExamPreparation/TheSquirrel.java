package MultidimensionalArrays_ExamPreparation;

import java.util.Scanner;

public class TheSquirrel {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int lengthOFTheField = Integer.parseInt(scanner.nextLine());
        String[] directions = scanner.nextLine().split(",\\s+");
        char[][] field = new char[lengthOFTheField][lengthOFTheField];
        fillMatrix(scanner,field);

        int hazelnuts = 0;

        int squirrelRow = squirrelRow(field);
        int squirrelCol = squirrelCol(field);

        while (true){

            for (String currentDirection : directions) {
                switch (currentDirection) {
                    case "up":
                        if(checkIndex(field, squirrelRow - 1, squirrelCol)){
                            if(field[squirrelRow - 1][squirrelCol] == '*'){
                                field[squirrelRow - 1][squirrelCol] = 's';
                                field[squirrelRow][squirrelCol] = '*';
                                squirrelRow--;
                            }else if(field[squirrelRow - 1][squirrelCol] == 'h'){
                                hazelnuts++;
                                field[squirrelRow - 1][squirrelCol] = '*';
                                field[squirrelRow][squirrelCol] = '*';
                                if(hazelnuts == 3){
                                    System.out.println("Good job! You have collected all hazelnuts!");
                                    System.out.println("Hazelnuts collected: " + hazelnuts);
                                    return;
                                }
                                squirrelRow--;
                            }else if (field[squirrelRow - 1][squirrelCol] == 't'){
                                System.out.println("Unfortunately, the squirrel stepped on a trap...");
                                System.out.println("Hazelnuts collected: " + hazelnuts);
                                return;
                            }
                        }else{
                            System.out.println("The squirrel is out of the field.");
                            System.out.println("Hazelnuts collected: " + hazelnuts);
                            return;
                        }
                        break;
                    case "down":
                        if(checkIndex(field, squirrelRow + 1, squirrelCol)){
                            if(field[squirrelRow + 1][squirrelCol] == '*'){
                                field[squirrelRow + 1][squirrelCol] = 's';
                                field[squirrelRow][squirrelCol] = '*';
                                squirrelRow++;
                            }else if(field[squirrelRow + 1][squirrelCol] == 'h'){
                                hazelnuts++;
                                field[squirrelRow + 1][squirrelCol] = '*';
                                field[squirrelRow][squirrelCol] = '*';
                                if(hazelnuts == 3){
                                    System.out.println("Good job! You have collected all hazelnuts!");
                                    System.out.println("Hazelnuts collected: " + hazelnuts);
                                    return;
                                }
                                squirrelRow++;
                            }else if (field[squirrelRow + 1][squirrelCol] == 't'){
                                System.out.println("Unfortunately, the squirrel stepped on a trap...");
                                System.out.println("Hazelnuts collected: " + hazelnuts);
                                return;
                            }
                        }else{
                            System.out.println("The squirrel is out of the field.");
                            System.out.println("Hazelnuts collected: " + hazelnuts);
                            return;
                        }
                        break;
                    case "right":
                        if(checkIndex(field, squirrelRow, squirrelCol + 1)){
                            if(field[squirrelRow][squirrelCol + 1] == '*'){
                                field[squirrelRow][squirrelCol + 1] = 's';
                                field[squirrelRow][squirrelCol] = '*';
                               squirrelCol++;
                            }else if(field[squirrelRow][squirrelCol+1] == 'h'){
                                hazelnuts++;
                                field[squirrelRow][squirrelCol+1] = '*';
                                field[squirrelRow][squirrelCol] = '*';
                                if(hazelnuts == 3){
                                    System.out.println("Good job! You have collected all hazelnuts!");
                                    System.out.println("Hazelnuts collected: " + hazelnuts);
                                    return;
                                }
                                 squirrelCol++;
                            }else if (field[squirrelRow][squirrelCol+1] == 't'){
                                System.out.println("Unfortunately, the squirrel stepped on a trap...");
                                System.out.println("Hazelnuts collected: " + hazelnuts);
                                return;
                            }
                        }else{
                            System.out.println("The squirrel is out of the field.");
                            System.out.println("Hazelnuts collected: " + hazelnuts);
                            return;
                        }
                        break;
                    case "left":
                        if(checkIndex(field, squirrelRow, squirrelCol - 1)){
                            if(field[squirrelRow][squirrelCol - 1] == '*'){
                                field[squirrelRow][squirrelCol - 1] = 's';
                                field[squirrelRow][squirrelCol] = '*';
                                squirrelCol--;
                            }else if(field[squirrelRow][squirrelCol-1] == 'h'){
                                hazelnuts++;
                                field[squirrelRow][squirrelCol-1] = '*';
                                field[squirrelRow][squirrelCol] = '*';
                                if(hazelnuts == 3){
                                    System.out.println("Good job! You have collected all hazelnuts!");
                                    System.out.println("Hazelnuts collected: " + hazelnuts);
                                    return;
                                }
                                squirrelCol--;
                            }else if (field[squirrelRow][squirrelCol-1] == 't'){
                                System.out.println("Unfortunately, the squirrel stepped on a trap...");
                                System.out.println("Hazelnuts collected: " + hazelnuts);
                                return;
                            }
                        }else{
                            System.out.println("The squirrel is out of the field.");
                            System.out.println("Hazelnuts collected: " + hazelnuts);
                            return;
                        }
                        break;
                }
            }

                 if(hazelnuts < 3){
                     System.out.println("There are more hazelnuts to collect.");
                     System.out.println("Hazelnuts collected: " + hazelnuts);
                     return;
                  }
        }

    }

    public static void fillMatrix(Scanner scanner, char[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            char[] data = scanner.nextLine().toCharArray();
            matrix[row] = data;
        }
    }

    public static boolean checkIndex(char [][] field, int row, int col){
        return  row >= 0 && row < field.length
                && col >= 0 && col < field[row].length;
    }
    public static void printMatrix(char[][] matrix) {

        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
    public static int squirrelRow(char[][] matrix) {
        int squirrelRow = 0;

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 's') {
                    squirrelRow = row;
                    break;
                }
            }
        }

        return squirrelRow;
    }
    public static int squirrelCol(char[][] matrix) {
        int squirrelCol = 0;

        for (char[] chars : matrix) {
            for (int col = 0; col < chars.length; col++) {
                if (chars[col] == 's') {
                    squirrelCol = col;
                    break;
                }
            }
        }

        return squirrelCol;
    }
}
