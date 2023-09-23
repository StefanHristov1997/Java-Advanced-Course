package FunctionalProgramming_05_Lab;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = readArray(scanner);

        int count = numbers.size();

        Function<List<Integer>, Integer> sumOfElements = num -> {
            int sum = 0;

            for (int e : num) {
                sum += e;
            }

            return sum;
        };

        int sum = sumOfElements.apply(numbers);

        System.out.println("Count = " + count);
        System.out.println("Sum = " + sum);


    }

    private static List<Integer> readArray(Scanner scanner) {

        return Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
