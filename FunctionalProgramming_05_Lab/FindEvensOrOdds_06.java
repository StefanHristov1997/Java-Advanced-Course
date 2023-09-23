package FunctionalProgramming_05_Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvensOrOdds_06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(" ");

        int start = Integer.parseInt(data[0]);
        int end = Integer.parseInt(data[1]);
        String command = scanner.nextLine();

        List<Integer> result = getEvenOrOdd(command, start, end);

        result.forEach(e-> System.out.print(e + " "));

    }

    private static List<Integer> getEvenOrOdd(String command, int start, int end) {
        List<Integer> resultList = new ArrayList<>();
        switch (command) {
            case "even":
                Predicate<Integer> isEven = e -> e % 2 == 0;
                for (int i = start; i <= end; i++) {
                    if (isEven.test(i)) {
                        resultList.add(i);
                    }
                }
                break;
            case "odd":
                Predicate<Integer> isOdd = e -> e % 2 != 0;
                for (int i = start; i <= end; i++) {
                    if (isOdd.test(i)) {
                        resultList.add(i);
                    }
                }
                break;
        }
        return resultList;
    }
}
