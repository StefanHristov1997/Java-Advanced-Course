package FunctionalProgramming_05_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetic_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = readList(scanner);

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            if (!nums.isEmpty()) {
                nums = applyCommands(nums, command);
            }

            command = scanner.nextLine();
        }

    }

    private static List<Integer> applyCommands(List<Integer> numbers, String command) {

        switch (command) {
            case "add":
                Function<List<Integer>, List<Integer>> addFun = list -> list.stream().map(num -> num += 1).collect(Collectors.toList());
                numbers = addFun.apply(numbers);
                break;
            case "multiply":
                Function<List<Integer>, List<Integer>> multiplyFun = list -> list.stream().map(num -> num *= 2).collect(Collectors.toList());
                numbers = multiplyFun.apply(numbers);
                break;
            case "subtract":
                Function<List<Integer>, List<Integer>> subtractFun = list -> list.stream().map(num -> num -= 1).collect(Collectors.toList());
                numbers = subtractFun.apply(numbers);
                break;
            case "print":
                Consumer<List<Integer>> printResult = list -> list.forEach(e -> System.out.print(e + " "));
                printResult.accept(numbers);
                System.out.println();
                break;
        }
        return numbers;
    }

    private static List<Integer> readList(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
