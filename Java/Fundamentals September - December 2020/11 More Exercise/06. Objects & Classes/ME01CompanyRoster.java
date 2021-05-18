import java.util.*;

public class ME01CompanyRoster {
    static class Employee {
        String name;
        double salary;
        String position;
        String department;
        String email;
        int age;

        public Employee(String name, double salary, String position, String department) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.email = "n/a";
            this.age = -1;
        }

        public Employee(String name, double salary, String position, String department, String email, int age) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.email = email;
            this.age = age;
        }

        public Employee(String name, double salary, String position, String department, String email) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.email = email;
            this.age = -1;
        }

        public Employee(String name, double salary, String position, String department, int age) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.email = "n/a";
            this.age = age;
        }

        public String getName() {
            return this.name;
        }

        public double getSalary() {
            return this.salary;
        }

        public String getEmail() {
            return this.email;
        }

        public int getAge() {
            return this.age;
        }
    }

    static class Department {
        String departmentName;
        List<Employee> employees;

        public Department(String departmentName) {
            this.departmentName = departmentName;
            this.employees = new ArrayList<>();
        }

        public String getDepartmentName() {
            return this.departmentName;
        }

        public void addEmployee(Employee employee) {
            this.employees.add(employee);
        }

        public List<Employee> getEmployees() {
            return this.employees;
        }

        public double averageSalary() {
            double totalSalaryDept = 0;
            for (Employee employee : this.employees) {
                totalSalaryDept += employee.getSalary();
            }

            return totalSalaryDept / this.employees.size();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        Map<String, Department> departments = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            String email = null;
            int age = 0;

            Employee employee = null;

            if (input.length == 6) {
                email = input[4];
                age = Integer.parseInt(input[5]);
                employee = new Employee(name, salary, position, department, email, age);

            } else if (input.length == 5) {

                if (input[4].matches("\\d+")) {
                    age = Integer.parseInt(input[4]);
                    employee = new Employee(name, salary, position, department, age);

                } else {
                    email = input[4];
                    employee = new Employee(name, salary, position, department, email);
                }

            } else {
                employee = new Employee(name, salary, position, department);
            }

            if (departments.containsKey(department)) {
                departments.get(department).addEmployee(employee);

            } else {
                Department newDepartment = new Department(department);
                newDepartment.addEmployee(employee);
                departments.put(department, newDepartment);
            }

        }

        double highestAverageSalary = 0;
        Department deptWithHighestAverageSalary = null;

        for (Map.Entry<String, Department> entry : departments.entrySet()) {
            Department currentDepartment = entry.getValue();
            if (highestAverageSalary < currentDepartment.averageSalary()) {
                highestAverageSalary = currentDepartment.averageSalary();
                deptWithHighestAverageSalary = currentDepartment;
            }
        }

        assert deptWithHighestAverageSalary != null;
        deptWithHighestAverageSalary.getEmployees().sort((e1, e2)->Double.compare(e2.getSalary(),e1.getSalary()));

        System.out.printf("Highest Average Salary: %s%n", deptWithHighestAverageSalary.getDepartmentName());
        StringBuilder sb = new StringBuilder();
        for (Employee employee : deptWithHighestAverageSalary.getEmployees()) {
            sb.append(System.lineSeparator()).
                    append(String.format("%s %.2f %s %d",
                            employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge()));
        }

        System.out.print(sb.toString().trim());

    }
}
