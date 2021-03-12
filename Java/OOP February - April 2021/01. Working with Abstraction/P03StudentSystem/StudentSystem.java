package P03StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private final Map<String, Student> studentInfo;

    public StudentSystem() {
        this.studentInfo = new HashMap<>();
    }

    public Map<String, Student> getStudentInfo() {
        return this.studentInfo;
    }

    public String parseCommand(String[] input) {
//        Scanner scanner = new Scanner(System.in);
//        String[] input = scanner.nextLine().split(" ");

        String result = null;

        if (input[0].equals("Create")) {
            createStudent(input);
        } else if (input[0].equals("Show")) {
           result = showStudent(input);
        }

        return result;
    }


    private String showStudent(String[] input) {
        String name = input[1];

        if (studentInfo.containsKey(name)) {
            Student student = studentInfo.get(name);

            return student.toString();
        }
        return null;
    }

    private void createStudent(String[] input) {
        String name = input[1];
        int age = Integer.parseInt(input[2]);
        double grade = Double.parseDouble(input[3]);
        if (!studentInfo.containsKey(name)) {
            Student student = new Student(name, age, grade);
            studentInfo.put(name, student);
        }
    }
}
