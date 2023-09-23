package StreamsFilesAndDirectories_Exercise_04;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LineNumbers_05 {
    public static void main(String[] args) throws IOException {

        String inPath = "D:\\SoftUni\\Папки с проекти\\Java Advanced 2023\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        FileInputStream inputStream = new FileInputStream(inPath);
        Scanner reader = new Scanner(inputStream);

        String outPath = "D:\\SoftUni\\Папки с проекти\\Java Advanced 2023\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\FileForTask5.txt";

        PrintWriter writer = new PrintWriter(outPath);

        int rows = 1;

        while (reader.hasNextLine()) {
            String line = reader.nextLine();

            writer.println(rows + ". " + line);
            rows++;
        }

        writer.close();
        reader.close();
        inputStream.close();
    }
}
