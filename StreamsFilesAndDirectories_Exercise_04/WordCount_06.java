package StreamsFilesAndDirectories_Exercise_04;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordCount_06 {
    public static void main(String[] args) throws IOException {

        String inputPath = "D:\\SoftUni\\Папки с проекти\\Java Advanced 2023\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";

        FileInputStream inputStream = new FileInputStream(inputPath);

        Scanner reader = new Scanner(inputStream);
        List<String> words = new ArrayList<>();

        String line = "";

        while (reader.hasNext()) {

            line = reader.next();

            words.add(line);

        }

        inputStream.close();
        reader.close();

        String newPath = "D:\\SoftUni\\Папки с проекти\\Java Advanced 2023\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        FileInputStream fileInputStream = new FileInputStream(newPath);

        reader = new Scanner(fileInputStream);

        int countFirstWord = 0;
        int countSecondWord = 0;
        int countThirdWord = 0;

        String currentWord = "";
        while (reader.hasNext()) {

            if (currentWord.equals(words.get(0))) {
                countFirstWord++;
            } else if (currentWord.equals(words.get(1))) {
                countSecondWord++;
            } else if (currentWord.equals(words.get(2))) {
                countThirdWord++;
            }

            currentWord = reader.next();
        }

        System.out.println(words.get(0) + " - " + countFirstWord);
        System.out.println(words.get(1) + " - " + countSecondWord);
        System.out.println(words.get(2) + " - " + countThirdWord);

        fileInputStream.close();
        reader.close();
    }
}
