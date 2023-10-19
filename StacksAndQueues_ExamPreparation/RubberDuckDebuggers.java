package StacksAndQueues_ExamPreparation;

import java.util.*;

public class RubberDuckDebuggers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> programmerTimesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(programmerTimesQueue::offer);
        Deque<Integer> numberOfTasksStack= new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(numberOfTasksStack::push);

        Map<String, Integer> rubberDucks = new LinkedHashMap<>();

        rubberDucks.put("Darth Vader Ducky", 0);
        rubberDucks.put("Thor Ducky", 0);
        rubberDucks.put("Big Blue Rubber Ducky", 0);
        rubberDucks.put("Small Yellow Rubber Ducky", 0);

        while (!programmerTimesQueue.isEmpty() && !numberOfTasksStack.isEmpty()){
            int result = programmerTimesQueue.peek() * numberOfTasksStack.peek();

            if(result >= 0 && result <= 60){
               rubberDucks.put("Darth Vader Ducky",rubberDucks.get("Darth Vader Ducky") + 1);
               programmerTimesQueue.poll();
               numberOfTasksStack.pop();
            }else if (result > 60 && result <= 120){
                rubberDucks.put("Thor Ducky",rubberDucks.get("Thor Ducky") + 1);
                programmerTimesQueue.poll();
                numberOfTasksStack.pop();
            }else if (result > 120 && result <= 180){
                rubberDucks.put("Big Blue Rubber Ducky",rubberDucks.get("Big Blue Rubber Ducky") + 1);
                programmerTimesQueue.poll();
                numberOfTasksStack.pop();
            }else if (result > 180 && result <= 240){
                rubberDucks.put("Small Yellow Rubber Ducky", rubberDucks.get("Small Yellow Rubber Ducky") + 1);
                programmerTimesQueue.poll();
                numberOfTasksStack.pop();
            }else{
                 int decrease = numberOfTasksStack.pop() - 2;
                 numberOfTasksStack.push(decrease);
                 if(programmerTimesQueue.size() > 1){
                     int moveProgrammerTime = programmerTimesQueue.poll();
                     programmerTimesQueue.offer(moveProgrammerTime);
                 }
            }
        }

        if(numberOfTasksStack.isEmpty()){
            System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
            rubberDucks.forEach((key, value) -> System.out.println(key + ": " + value));
        }

    }
}
