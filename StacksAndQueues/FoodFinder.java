package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FoodFinder {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Character> vowels = new ArrayDeque<>();

        fillDeque(scanner, vowels);

        ArrayDeque<Character> consonants = new ArrayDeque<>();

        fillStack(scanner, consonants);

        List<String> words = new ArrayList<>(List.of("pear", "flour", "pork", "olive"));
        List<Character> letters = new ArrayList<>();

        while (!consonants.isEmpty()) {
            char firstLetter = vowels.peek();
            char lastLetter = consonants.peek();


            for (String word : words) {

                for (int j = 0; j < word.length(); j++) {
                    char currentLetter = word.charAt(j);
                    if (firstLetter == currentLetter) {
                        letters.add(currentLetter);
                    }
                    if (lastLetter == currentLetter) {
                        letters.add(currentLetter);
                    }
                }
            }

            vowels.poll();
            vowels.offer(firstLetter);
            consonants.pop();
        }


        List<String> founded = foundedWords(words, letters);


        System.out.printf("Words found: %d\n", founded.size());
        founded.forEach(System.out::println);

    }

    private static List<String> foundedWords(List<String> words, List<Character> letters) {
        boolean isFound = false;
        List<String> founded = new ArrayList<>();

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                for (char chh : letters) {
                    if (chh == ch) {
                        isFound = true;
                        break;
                    } else {
                        isFound = false;
                    }
                }
                if (!isFound) {
                    break;
                }
            }
            if (isFound) {
                founded.add(word);
            }
        }
        return founded;
    }

    public static void fillDeque(Scanner scanner, ArrayDeque<Character> deque) {
        String[] vowelData = scanner.nextLine().split("\\s+");

        for (String vowelDatum : vowelData) {
            deque.offer(vowelDatum.charAt(0));
        }
    }

    public static void fillStack(Scanner scanner, ArrayDeque<Character> stack) {
        String[] vowelData = scanner.nextLine().split("\\s+");

        for (String vowelDatum : vowelData) {
            stack.push(vowelDatum.charAt(0));
        }
    }


}
