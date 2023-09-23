package StreamFilesAndDirectories_Lab_04;

import java.io.File;

public class ListFiles_07 {
    public static void main(String[] args) {

        File file = new File("D:\\SoftUni\\Папки с проекти\\Java Advanced 2023\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File fille : files){
                    if(!fille.isDirectory()){
                        System.out.printf("%s: [%d]\n", fille.getName(), fille.length());
                    }
                }
            }
        }
    }
}
