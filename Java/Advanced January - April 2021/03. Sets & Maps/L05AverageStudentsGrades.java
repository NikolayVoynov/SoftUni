import java.util.*;

public class L05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> student = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);

            student.putIfAbsent(name, new ArrayList<>());
            student.get(name).add(grade);
        }

        for (Map.Entry<String, List<Double>> entry : student.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            entry.getValue().stream().forEach(e-> System.out.printf("%.2f ", e));
            double average = 0;
            double sum = 0;
            for (Double entryValue : entry.getValue()) {
                sum += entryValue;
            }
            average = sum / entry.getValue().size();
            System.out.print(String.format("(avg: %.2f)", average));
            System.out.println();
        }


    }
}
