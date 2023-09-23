package StreamsFilesAndDirectories_Exercise_04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class SumLines_01 {
    public static void main(String[] args) throws IOException {

        String inPath = "D:\\SoftUni\\Папки с проекти\\Java Advanced 2023\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        FileInputStream inputStream = new FileInputStream(inPath);

        Scanner reader = new Scanner(inputStream);

        String line = reader.nextLine();

        while (reader.hasNextLine()) {
            long sum = 0;

            for (char symbol : line.toCharArray()) {
                sum += (int) symbol;
            }

            System.out.println(sum);
            line = reader.nextLine();
        }

        reader.close();
        inputStream.close();
    }
}
