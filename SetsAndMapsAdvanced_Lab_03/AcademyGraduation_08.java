package SetsAndMapsAdvanced_Lab_03;

import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int students = Integer.parseInt(scanner.nextLine());

        Map<String, Double> gradeMap = new TreeMap<>();

        for (int studen = 1; studen <= students; studen++) {
            String studentName = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).collect(Collectors.toList());
            double finalScore = 0;

            for (int i = 0; i < grades.size(); i++) {
                finalScore += grades.get(i);
            }

            finalScore = finalScore / grades.size();

            gradeMap.put(studentName, finalScore);

        }

        gradeMap.forEach((key, value) -> System.out.printf("%s is graduated with %s\n", key, value));
    }
}
