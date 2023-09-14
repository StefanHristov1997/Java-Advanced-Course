package MultidimensionalArrays_Lab_02;

import java.util.Scanner;

public class IntersectionOfTwoMatrices_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());


        String[][] firstMatrix = new String[rows][columns];


        for (int row = 0; row < firstMatrix.length; row++) {
            String[] firstMatrixColumnData = scanner.nextLine().split("\\s+");
            for (int column = 0; column < firstMatrix[row].length; column++) {
                firstMatrix[row][column] = firstMatrixColumnData[column];
            }
        }

        String[][] secondMatrix = new String[rows][columns];

        for (int row = 0; row < secondMatrix.length; row++) {
            String[] secondMatrixColumnData = scanner.nextLine().split("\\s+");

            for (int column = 0; column < secondMatrix[row].length; column++) {
                secondMatrix[row][column] = secondMatrixColumnData[column];
            }
        }

        //String[][] finalMatrix = new String[rows][columns];

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int column = 0; column < firstMatrix[row].length; column++) {
                if (firstMatrix[row][column].equals(secondMatrix[row][column])) {
                    //      finalMatrix[row][column] = firstMatrix[row][column];
                    System.out.print(firstMatrix[row][column] + " ");
                } else {
                    //      finalMatrix[row][column] = "*";
                    System.out.print("*" + " ");
                }

            }

            System.out.println();
        }

//        for (int row = 0; row < finalMatrix.length; row++) {
//
//            for (int column = 0; column < finalMatrix[row].length; column++) {
//                System.out.print(finalMatrix[row][column] + " ");
//            }
//
//            System.out.println();
//        }

    }
}

