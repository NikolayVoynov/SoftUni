import java.util.Scanner;

public class AverageNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double sum = 0;
        double averageSum = 0;

        for (int i = 1; i <= n; i++) {
            double input = Double.parseDouble(scanner.nextLine());
            sum += input;

        }

        averageSum = sum / n;
        System.out.printf("%.2f", averageSum);

    }
}
