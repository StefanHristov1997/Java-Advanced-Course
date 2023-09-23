package StreamFilesAndDirectories_Lab_04;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile_01 {
    public static void main(String[] args) throws IOException {
        String path = "D:\\SoftUni\\Папки с проекти\\Java Advanced 2023\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream fileReader = new FileInputStream(path);

        int currentByte = fileReader.read();

        while (currentByte >= 0) {

            System.out.print(Integer.toBinaryString(currentByte) + " ");

            currentByte = fileReader.read();
        }

        fileReader.close();
    }
}
