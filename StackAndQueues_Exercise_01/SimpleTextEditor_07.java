package StackAndQueues_Exercise_01;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor_07 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder modifier = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int commands = 1; commands <= n; commands++) {
            String[] command = scanner.nextLine().split("\\s+");
            int commandName = Integer.parseInt(command[0]);

            switch (commandName) {
                case 1:
                    stack.push(modifier.toString());
                    String textToAppend = command[1];
                    modifier.append(textToAppend);
                    break;
                case 2:
                    stack.push(modifier.toString());
                    int count = Integer.parseInt(command[1]);
                    modifier.delete(modifier.length() - count, modifier.length());
                    break;
                case 3:
                    int index = Integer.parseInt(command[1]);
                    System.out.println(modifier.charAt(index - 1));
                    break;
                case 4:
                    modifier = new StringBuilder(stack.poll());
                    break;
            }
        }
    }
}
