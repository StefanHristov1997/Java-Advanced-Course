package StreamFilesAndDirectories_Lab_04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFile_02 {
    public static void main(String[] args) throws IOException {

        String pathRead = "D:\\SoftUni\\Папки с проекти\\Java Advanced 2023\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathWrite = "D:\\SoftUni\\Папки с проекти\\Java Advanced 2023\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\fileForTask2.txt";


        FileInputStream fileInputStream = new FileInputStream(pathRead);
        FileOutputStream fileOutputStream = new FileOutputStream(pathWrite);

        int oneByte = fileInputStream.read();

        while (oneByte >= 0) {
            char currentSymbol = (char) oneByte;

            if (currentSymbol != '.' && currentSymbol != ',' && currentSymbol != '!' && currentSymbol != '?') {
                fileOutputStream.write(currentSymbol);
            }

            oneByte = fileInputStream.read();
        }

        fileInputStream.close();
        fileOutputStream.close();

    }
}
