package SetsAndMapsAdvanced_Lab_03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class WarNumberGame_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        HashSet<Integer> firstPlayerCards = new LinkedHashSet<>();
        HashSet<Integer> secondPlayerCards = new LinkedHashSet<>();

        int[] firstCards = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] secondCards = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < 20; i++) {
            firstPlayerCards.add(firstCards[i]);
        }

        for (int i = 0; i < 20; i++) {
            secondPlayerCards.add(secondCards[i]);
        }


        int rounds = 50;
        boolean firstPlayerWin = false;
        boolean secondPlayerWin = false;


        while (rounds > 0) {

            int firstNumber = firstPlayerCards.iterator().next();
            firstPlayerCards.remove(firstNumber);

            if (firstPlayerCards.isEmpty()) {
                secondPlayerWin = true;
                break;
            }

            int secondNumber = secondPlayerCards.iterator().next();
            secondPlayerCards.remove(secondNumber);

            if (secondPlayerCards.isEmpty()) {
                firstPlayerWin = true;
                break;
            }

            if (firstNumber > secondNumber) {
                firstPlayerCards.add(firstNumber);
                firstPlayerCards.add(secondNumber);
            } else if (secondNumber > firstNumber){
                secondPlayerCards.add((firstNumber));
                secondPlayerCards.add(secondNumber);
            }

            rounds--;
        }

        if (firstPlayerWin || firstPlayerCards.size() > secondPlayerCards.size()) {
            System.out.println("First player win!");
        } else if (secondPlayerWin || secondPlayerCards.size() > firstPlayerCards.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }

    }
}
