import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        String metricIn = scanner.nextLine();
        String metricOut = scanner.nextLine();

        if (metricIn.equals("mm") && metricOut.equals("m")) {
            number = number * 0.001;
            System.out.printf("%.3f", number);
        } else if (metricIn.equals("cm") && metricOut.equals("m")) {
            number = number * 0.01;
            System.out.printf("%.3f", number);
        }

        if (metricIn.equals("m") && metricOut.equals("mm")) {
            number = number * 1000;
            System.out.printf("%.3f", number);
        } else if (metricIn.equals("m") && metricOut.equals("cm")) {
            number = number * 100;
            System.out.printf("%.3f", number);
        }

        if (metricIn.equals("mm") && metricOut.equals("cm")) {
            number = number * 0.1;
            System.out.printf("%.3f", number);
        } else if (metricIn.equals("cm") && metricOut.equals("mm")) {
            number = number * 10;
            System.out.printf("%.3f", number);
        }

    }
}
