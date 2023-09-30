package CompanyRoster_02;

public class Employee {

    private String name;
    private Double salary;
    private String position;
    private String department;
    private String email;
    private int age;


    public Double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        String salaryPrint = String.format("%.2f", salary);
        info.append(name).append(" ").append(salaryPrint).append(" ");

        if (email != null) {
            info.append(email).append(" ");
        } else {
            info.append("n/a" + " ");
        }

        if (age != 0) {
            info.append(age);
        } else {
            info.append("-1");
        }

        return info.toString();
    }

    public Employee(String name, Double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public Employee(String name, Double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
    }

    public Employee(String name, Double salary, String position, String department, String email) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
    }

    public Employee(String name, Double salary, String position, String department, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.age = age;
    }

}
