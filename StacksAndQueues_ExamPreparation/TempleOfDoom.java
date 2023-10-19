package StacksAndQueues_ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class TempleOfDoom {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> toolQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(toolQueue::offer);

        Deque<Integer> substancesStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(substancesStack::push);


        List<Integer> challengesList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        boolean challengeCompleted = false;

        while (!toolQueue.isEmpty() && !substancesStack.isEmpty()) {
            int firstNumber = toolQueue.peek();
            int lastNumber = substancesStack.peek();
            int result = firstNumber * lastNumber;
            boolean isFind = false;

            for (int i = 0; i < challengesList.size(); i++) {
                if (challengesList.get(i) == result) {
                    toolQueue.poll();
                    substancesStack.pop();
                    challengesList.remove(challengesList.get(i));
                    isFind = true;
                    break;
                }
            }

            if (challengesList.isEmpty()) {
                challengeCompleted = true;
            }

            if (challengeCompleted) {
                break;
            }

            if (!isFind) {
                toolQueue.poll();
                firstNumber++;
                toolQueue.offer(firstNumber);

                substancesStack.pop();
                lastNumber--;
                substancesStack.push(lastNumber);

                if (lastNumber == 0) {
                    substancesStack.pop();
                }

            }
        }

        if (challengeCompleted) {
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
            if (!toolQueue.isEmpty()) {
                System.out.print("Tools: ");
                System.out.print(String.join(", ", toolQueue.toString().replaceAll("[\\[\\]]", "")));
                System.out.println();
            }
            if (!substancesStack.isEmpty()) {
                System.out.print("Substances: ");
                System.out.print(String.join(", ", substancesStack.toString().replaceAll("[\\[\\]]", "")));
            }
        } else {
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
            if (!toolQueue.isEmpty()) {
                System.out.print("Tools: ");
                System.out.print(String.join(", ", toolQueue.toString().replaceAll("[\\[\\]]", "")));
                System.out.println();
            }

            if (!substancesStack.isEmpty()) {
                System.out.print("Substances: ");
                System.out.print(String.join(", ", substancesStack.toString().replaceAll("[\\[\\]]", "")));
                System.out.println();
            }

            System.out.print("Challenges: ");
            System.out.print(String.join(", ", challengesList.toString().replaceAll("[\\[\\]]", "")));
        }
    }
}
