import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E05Students {

    static class Student {
        String firstName;
        String lastName;
        double grade;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public double getGrade() {
            return grade;
        }

        public void setGrade(double grade) {
            this.grade = grade;
        }

        public Student(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        public String toString() {
            return String.format("%s %s: %.2f", getFirstName(), getLastName(), getGrade());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Student> allStudents = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");
            String firstName = data[0];
            String lastName = data[1];
            double grade = Double.parseDouble(data[2]);

            Student student = new Student(firstName, lastName, grade);

            allStudents.add(student);
        }

        allStudents
                .stream()
                .sorted((student1, student2) -> Double.compare(student2.getGrade(), student1.getGrade()))
                .forEach(student -> System.out.println(student.toString()));
    }

}
