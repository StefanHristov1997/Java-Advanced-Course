package MultidimensionalArrays_Exercise_02;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling_05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = rowsAndCols[0];
        int columns = rowsAndCols[1];

        String[][] table = new String[rows][columns];


        for (int row = 0; row < table.length; row++) {
            String[] tableData = scanner.nextLine().split("\\s+");

            for (int column = 0; column < table[row].length; column++) {

                table[row][column] = tableData[column];
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("END")) {
            String[] commandParts = command.split("\\s+");
            boolean isInvalid = false;
            boolean isSwap = false;

            if (commandParts[0].equals("swap") && commandParts.length == 5) {
                int row1 = Integer.parseInt(commandParts[1]);
                int column1 = Integer.parseInt(commandParts[2]);
                int row2 = Integer.parseInt(commandParts[3]);
                int column2 = Integer.parseInt(commandParts[4]);

                for (int row = 0; row < table.length; row++) {

                    for (int column = 0; column < table[row].length; column++) {

                        if (row1 > table.length || row2 > table.length || column1 > table[row].length || column2 > table[row].length) {
                            System.out.println("Invalid input!");
                            isInvalid = true;
                            break;
                        } else {
                            String oldElement = table[row1][column1];
                            table[row1][column1] = table[row2][column2];
                            table[row2][column2] = oldElement;

                            isSwap = true;

                            if (isSwap) {
                                for (int i = 0; i < table.length; i++) {
                                    for (int j = 0; j < table[row].length; j++) {
                                        System.out.print(table[i][j] + " ");
                                    }
                                    System.out.println();
                                }
                            }
                        }

                        if (isInvalid || isSwap) {
                            break;
                        }


                    }

                    if (isInvalid || isSwap) {
                        break;
                    }

                    System.out.println();

                }


            } else {
                System.out.println("Invalid input!");
            }


            command = scanner.nextLine();
        }
    }
}
