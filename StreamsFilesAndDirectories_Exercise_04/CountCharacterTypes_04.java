package StreamsFilesAndDirectories_Exercise_04;

import java.io.*;

public class CountCharacterTypes_04 {
    public static void main(String[] args) throws IOException {

        String inPath = "D:\\SoftUni\\Папки с проекти\\Java Advanced 2023\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        FileReader input = new FileReader(inPath);

        BufferedReader reader = new BufferedReader(input);

        String outPath = "D:\\SoftUni\\Папки с проекти\\Java Advanced 2023\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\FileForTask4.txt";

        PrintWriter writer = new PrintWriter(outPath);

        String line = reader.readLine();
        int vowels = 0;
        int punctuation = 0;
        int otherSymbols = 0;


        while (line != null) {

            for (char symbol : line.toCharArray()) {

                if (symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u') {
                    vowels++;
                } else if (symbol == '!' || symbol == '.' || symbol == ',' || symbol == '?') {
                    punctuation++;
                } else if (symbol != ' ') {
                    otherSymbols++;
                }
            }

            line = reader.readLine();
        }

        writer.println("Vowels: " + vowels);
        writer.println("Other symbols: " + otherSymbols);
        writer.println("Punctuation: " + punctuation);

        writer.close();
        reader.close();
        input.close();
    }
}
