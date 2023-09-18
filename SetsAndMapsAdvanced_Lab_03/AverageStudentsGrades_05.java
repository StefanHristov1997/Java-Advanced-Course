package SetsAndMapsAdvanced_Lab_03;

import java.util.*;

public class AverageStudentsGrades_05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int students = Integer.parseInt(scanner.nextLine());

        TreeMap<String, ArrayList<Double>> studentRecordMap = new TreeMap<>();
        TreeMap<String, Double> studentAvgMap = new TreeMap<>();

        for (int student = 1; student <= students; student++) {
            String[] data = scanner.nextLine().split("\\s+");
            String studentName = data[0];
            double grade = Double.parseDouble(data[1]);

            if (!studentRecordMap.containsKey(studentName)) {
                studentRecordMap.put(studentName, new ArrayList<>());
                studentRecordMap.get(studentName).add(grade);
                studentAvgMap.put(studentName, grade);
            } else {
                studentRecordMap.get(studentName).add(grade);
                studentAvgMap.put(studentName, studentAvgMap.get(studentName) + grade);
            }
        }
        studentRecordMap.entrySet().stream().forEach(e -> {
            System.out.printf("%s -> ", e.getKey());
            e.getValue().forEach(b -> {
                System.out.printf("%.2f ", b);
            });

            System.out.printf("(avg: %.2f)\n", studentAvgMap.get(e.getKey()) / e.getValue().size());

        });

    }
}
