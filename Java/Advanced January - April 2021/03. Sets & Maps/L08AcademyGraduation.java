import java.text.DecimalFormat;
import java.util.*;

public class L08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, double[]> student = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToDouble(Double::parseDouble).toArray();

            student.put(name, grades);
        }

        for (Map.Entry<String, double[]> entry : student.entrySet()) {
            double sum = 0;

            for (double value : entry.getValue()) {
                sum += value;
            }

            double average = sum / entry.getValue().length;

//            double sum = Arrays.stream(entry.getValue()).sum();
//            double average = sum / entry.getValue().length;

            DecimalFormat decimalFormat = new DecimalFormat("0.##############################");

            System.out.println(entry.getKey() + " is graduated with " + decimalFormat.format(average));
        }
    }
}
