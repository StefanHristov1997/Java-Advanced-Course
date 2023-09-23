package StreamFilesAndDirectories_Lab_04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExtractIntegers_04 {
    public static void main(String[] args) throws FileNotFoundException {
        String pathRead = "D:\\SoftUni\\Папки с проекти\\Java Advanced 2023\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream fileInputStream = new FileInputStream(pathRead);

        Scanner scanner = new Scanner(fileInputStream);

        while (scanner.hasNext()) {
            if(scanner.hasNextInt()){
                System.out.println(scanner.nextInt());
            }

            scanner.next();
        }
    }
}
