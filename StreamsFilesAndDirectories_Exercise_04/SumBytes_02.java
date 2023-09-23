package StreamsFilesAndDirectories_Exercise_04;

import java.io.*;

public class SumBytes_02 {
    public static void main(String[] args) throws IOException {
        String inPath = "D:\\SoftUni\\Папки с проекти\\Java Advanced 2023\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        FileReader input = new FileReader(inPath);

        BufferedReader reader = new BufferedReader(input);

        String line = reader.readLine();
        long sum = 0;

        while (line != null) {

            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }

            line = reader.readLine();
        }
        System.out.println(sum);
        reader.close();
        input.close();
    }
}
