package StreamsFilesAndDirectories_Exercise_04;

import java.io.File;
import java.io.IOException;

public class GetFolderSize_08 {
    public static void main(String[] args) throws IOException {

        File file = new File("D:\\SoftUni\\Папки с проекти\\Java Advanced 2023\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");



        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println(file.length());
            }
        }
    }
}

