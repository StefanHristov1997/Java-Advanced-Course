package StreamsFilesAndDirectories_Exercise_04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ALLCAPITALS_03 {
    public static void main(String[] args) throws IOException {

        String inPath = "D:\\SoftUni\\Папки с проекти\\Java Advanced 2023\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        FileReader fileReader = new FileReader(inPath);

        BufferedReader reader = new BufferedReader(fileReader);

        String outPath = "D:\\SoftUni\\Папки с проекти\\Java Advanced 2023\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\FileForTask3.txt";
        PrintWriter writer = new PrintWriter(outPath);

        String line = reader.readLine();

        while (line != null) {

            writer.println(line.toUpperCase());

            line = reader.readLine();
        }

        writer.close();
        reader.close();

    }
}
