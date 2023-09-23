package StreamFilesAndDirectories_Lab_04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes_03 {
    public static void main(String[] args) throws IOException {

        String readPath = "D:\\SoftUni\\Папки с проекти\\Java Advanced 2023\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String writePath = "D:\\SoftUni\\Папки с проекти\\Java Advanced 2023\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\fileForTask3.txt";


        FileInputStream inputStream = new FileInputStream(readPath);
        FileOutputStream fileOutputStream = new FileOutputStream(writePath);

        int oneByte = inputStream.read();

        while (oneByte >= 0) {

            if (oneByte == 32 || oneByte == 10) {
                fileOutputStream.write(oneByte);
            } else {
                String digits = String.valueOf(oneByte);
                for (int i = 0; i < digits.length(); i++) {
                    fileOutputStream.write(digits.charAt(i));
                }
            }

            oneByte = inputStream.read();
        }

        inputStream.close();
        fileOutputStream.close();
    }
}
