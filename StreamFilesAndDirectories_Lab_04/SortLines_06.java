package StreamFilesAndDirectories_Lab_04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines_06 {
    public static void main(String[] args) throws IOException {

        Path Inpath = Paths.get("D:\\SoftUni\\Папки с проекти\\Java Advanced 2023\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        Path Outpath = Paths.get("D:\\SoftUni\\Папки с проекти\\Java Advanced 2023\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\FileForTask6.txt");


        List<String> lines = Files.readAllLines(Inpath);

        Collections.sort(lines);

        Files.write(Outpath, lines);

    }
}