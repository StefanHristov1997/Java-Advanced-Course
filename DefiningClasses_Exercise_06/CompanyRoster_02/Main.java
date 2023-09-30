package CompanyRoster_02;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        Map<String, List<Employee>> departments = new HashMap<>();

        for (int i = 1; i <= lines; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String department = data[3];
            Employee employee = null;

            if (data.length == 6) {
                String email = data[4];
                int age = Integer.parseInt(data[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else if (data.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (data.length == 5) {
                String fourParameter = data[4];

                if (fourParameter.contains("@")) {
                    String email = fourParameter;
                    employee = new Employee(name, salary, position, department, email);
                } else {
                    int age = Integer.parseInt(fourParameter);
                    employee = new Employee(name, salary, position, department, age);
                }
            }


            if (departments.containsKey(department)) {
                departments.get(department).add(employee);
            } else {
                departments.put(department, new ArrayList<>());
                departments.get(department).add(employee);
            }
        }

        String maxDepartmentSalary = (departments.entrySet().stream().
                max(Comparator.comparingDouble(entry -> avgSalary(entry.getValue()))))
                .get()
                .getKey();

        System.out.println("Highest Average Salary: " + maxDepartmentSalary);

        List<Employee> employeeList = departments.get(maxDepartmentSalary);
        employeeList.sort(Comparator.comparingDouble(Employee::getSalary));
        Collections.reverse(employeeList);

        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

    }

    public static double avgSalary(List<Employee> employees) {
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }

        return sum / employees.size();
    }
}
