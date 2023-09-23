package SetsAndMapsAdvanced_Exercise_03;

import java.util.*;

public class HandsOfCards_07 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String deck = scanner.nextLine();
        Map<String, LinkedHashSet<String>> playersMap = new LinkedHashMap<>();

        while (!deck.equals("JOKER")) {
            String stringReplace = deck.replaceAll("\\:", ",");
            String[] cards = stringReplace.split(",\\s+");
            String name = cards[0];

            if (playersMap.containsKey(name)) {
                for (int card = 1; card < cards.length; card++) {
                    playersMap.get(name).add(cards[card]);
                }

            } else {
                playersMap.put(name, new LinkedHashSet<>());
                for (int card = 1; card < cards.length; card++) {
                    playersMap.get(name).add(cards[card]);
                }

            }

            deck = scanner.nextLine();
        }


        for (Map.Entry<String, LinkedHashSet<String>> stringLinkedHashSetEntry : playersMap.entrySet()) {
            String currentName = stringLinkedHashSetEntry.getKey();
            int sum = 0;

            for (String card : stringLinkedHashSetEntry.getValue()) {

                if (card.equals("2C")) {
                    sum += 2;
                } else if (card.equals("2D")) {
                    sum += 4;
                } else if (card.equals("2H")) {
                    sum += 6;
                } else if (card.equals("2S")) {
                    sum += 8;
                } else if (card.equals("3C")) {
                    sum += 3;
                } else if (card.equals("3D")) {
                    sum += 6;
                } else if (card.equals("3H")) {
                    sum += 9;
                } else if (card.equals("3S")) {
                    sum += 12;
                } else if (card.equals("4C")) {
                    sum += 4;
                } else if (card.equals("4D")) {
                    sum += 8;
                } else if (card.equals("4H")) {
                    sum += 12;
                } else if (card.equals("4S")) {
                    sum += 14;
                } else if (card.equals("5C")) {
                    sum += 5;
                } else if (card.equals("5D")) {
                    sum += 10;
                } else if (card.equals("5H")) {
                    sum += 15;
                } else if (card.equals("5S")) {
                    sum += 20;
                } else if (card.equals("6C")) {
                    sum += 6;
                } else if (card.equals("6D")) {
                    sum += 12;
                } else if (card.equals("6H")) {
                    sum += 18;
                } else if (card.equals("6S")) {
                    sum += 24;
                } else if (card.equals("7C")) {
                    sum += 7;
                } else if (card.equals("7D")) {
                    sum += 14;
                } else if (card.equals("7H")) {
                    sum += 21;
                } else if (card.equals("7S")) {
                    sum += 28;
                } else if (card.equals("8C")) {
                    sum += 8;
                } else if (card.equals("8D")) {
                    sum += 16;
                } else if (card.equals("8H")) {
                    sum += 24;
                } else if (card.equals("8S")) {
                    sum += 32;
                } else if (card.equals("9C")) {
                    sum += 9;
                } else if (card.equals("9D")) {
                    sum += 18;
                } else if (card.equals("9H")) {
                    sum += 27;
                } else if (card.equals("9S")) {
                    sum += 36;
                } else if (card.equals("10C")) {
                    sum += 10;
                } else if (card.equals("10D")) {
                    sum += 20;
                } else if (card.equals("10H")) {
                    sum += 30;
                } else if (card.equals("10S")) {
                    sum += 40;
                } else if (card.equals("JC")) {
                    sum += 11;
                } else if (card.equals("JD")) {
                    sum += 22;
                } else if (card.equals("JH")) {
                    sum += 33;
                } else if (card.equals("JS")) {
                    sum += 44;
                } else if (card.equals("QC")) {
                    sum += 12;
                } else if (card.equals("QD")) {
                    sum += 24;
                } else if (card.equals("QH")) {
                    sum += 36;
                } else if (card.equals("QS")) {
                    sum += 48;
                } else if (card.equals("KC")) {
                    sum += 13;
                } else if (card.equals("KD")) {
                    sum += 26;
                } else if (card.equals("KH")) {
                    sum += 39;
                } else if (card.equals("KS")) {
                    sum += 52;
                } else if (card.equals("AC")) {
                    sum += 14;
                } else if (card.equals("AD")) {
                    sum += 28;
                } else if (card.equals("AH")) {
                    sum += 42;
                } else if (card.equals("AS")) {
                    sum += 56;
                }
            }

            System.out.println(currentName+ ": " + sum);
        }

    }

}
