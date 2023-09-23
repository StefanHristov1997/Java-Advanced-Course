package StreamFilesAndDirectories_Lab_04;

import java.io.*;
import java.util.Scanner;

public class WriteEveryThirdLine_05 {
    public static void main(String[] args) throws IOException {

        String pathRead = "D:\\SoftUni\\Папки с проекти\\Java Advanced 2023\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "D:\\SoftUni\\Папки с проекти\\Java Advanced 2023\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\FileForTask5.txt";

        FileInputStream inputStream = new FileInputStream(pathRead);
        FileOutputStream outputStream = new FileOutputStream(pathOut);

        Scanner reader = new Scanner(inputStream);
        PrintWriter writer = new PrintWriter(outputStream);

        int rows = 1;
        String line = reader.nextLine();

        while (reader.hasNextLine()) {

            if (rows % 3 == 0) {
                writer.println(line);
            }

            rows++;
            line = reader.nextLine();
        }

        inputStream.close();
        writer.close();
    }
}
