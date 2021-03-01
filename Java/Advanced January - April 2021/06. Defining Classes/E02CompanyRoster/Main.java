package E02CompanyRoster;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Department> departments = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];

            departments.putIfAbsent(department, new Department());

            Employee employee = null;

            if (input.length == 6) {
                String email = input[4];
                int age = Integer.parseInt(input[5]);

                employee = new Employee(name, salary, position, department, email, age);

            } else if (input.length == 5) {
                if (input[4].matches("^\\d+$")) {
                    int age = Integer.parseInt(input[4]);
                    String email = "n/a";

                    employee = new Employee(name, salary, position, department, age);

                } else {
                    String email = input[4];
                    int age = -1;

                    employee = new Employee(name, salary, position, department, email);
                }
            } else {
                employee = new Employee(name, salary, position, department);
            }

            departments.get(department).addEmployee(employee);
        }

        double highestAvgSalary = Double.MIN_VALUE;
        String deptHighestAvgSalary = "";

        for (Map.Entry<String, Department> entry : departments.entrySet()) {
            if (entry.getValue().getAverageSalary() > highestAvgSalary) {
                highestAvgSalary = entry.getValue().getAverageSalary();
                deptHighestAvgSalary = entry.getKey();
            }
        }

        Department department = departments.get(deptHighestAvgSalary);
        System.out.println(String.format("Highest Average Salary: %s", deptHighestAvgSalary));
        department.getEmployeeList().stream().sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(employee -> System.out.println(employee));

    }
}
