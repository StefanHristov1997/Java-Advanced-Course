package StacksAndQueues_ExamPreparation;

import java.util.*;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class ApocalypsePreparation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        Deque<Integer> textilesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(textilesQueue::offer);
        Deque<Integer> medicamentsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(medicamentsStack::push);

        Map<String, Integer> healingItems = new TreeMap<>();
        healingItems.put("Patch", 0);
        healingItems.put("Bandage", 0);
        healingItems.put("MedKit", 0);

        while (!textilesQueue.isEmpty() && !medicamentsStack.isEmpty()) {
            int firstTextiles = textilesQueue.poll();
            int lastMedicament = medicamentsStack.pop();

            int sum = firstTextiles + lastMedicament;

            if (sum == 30) {
                healingItems.put("Patch", healingItems.get("Patch") + 1);
            } else if (sum == 40) {
                healingItems.put("Bandage", healingItems.get("Bandage") + 1);
            } else if (sum >= 100) {
                sum -= 100;
                healingItems.put("MedKit", healingItems.get("MedKit") +1);
                if (sum != 0) {
                    if (!medicamentsStack.isEmpty()) {
                        int nextElement = medicamentsStack.pop();
                        medicamentsStack.push(nextElement + sum);
                    }
                }
            } else {
                lastMedicament += 10;
                medicamentsStack.push(lastMedicament);
            }
        }

        if (medicamentsStack.isEmpty() && textilesQueue.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        }else if (textilesQueue.isEmpty()){
            System.out.println("Textiles are empty.");
        }else{
            System.out.println("Medicaments are empty.");
        }



       healingItems = healingItems
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));


      healingItems =  healingItems.entrySet().stream().filter(e-> e.getValue() > 0).collect(
                toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                        LinkedHashMap::new));

      healingItems.forEach((key, value) -> System.out.println(key + " - " + value));

      if(!medicamentsStack.isEmpty()){
          System.out.print("Medicaments left: ");
          System.out.print(String.join(", ", medicamentsStack.toString().replaceAll("[\\[\\]]", "")));
      }

      if(!textilesQueue.isEmpty()){
          System.out.print("Textiles left: ");
          System.out.print(String.join(", ", textilesQueue.toString().replaceAll("[\\[\\]]", "")));
      }


    }
}