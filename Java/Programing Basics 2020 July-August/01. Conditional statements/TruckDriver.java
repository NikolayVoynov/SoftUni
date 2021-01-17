import java.util.Scanner;

public class TruckDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        double kmPerMonth = Double.parseDouble(scanner.nextLine());

        double salary = 0;

        if (kmPerMonth <= 5000) {
            switch (season) {
                case "Spring":
                case "Autumn":
                    salary = kmPerMonth * 0.75 * 0.90 * 4;
                    break;
                case "Summer":
                    salary = kmPerMonth * 0.90 * 0.90 * 4;
                    break;
                case "Winter":
                    salary = kmPerMonth * 1.05 * 0.90 * 4;
                    break;
            }
        } else if (kmPerMonth <= 10000) {
            switch (season) {
                case "Spring":
                case "Autumn":
                    salary = kmPerMonth * 0.95 * 0.90 * 4;
                    break;
                case "Summer":
                    salary = kmPerMonth * 1.1 * 0.90 * 4;
                    break;
                case "Winter":
                    salary = kmPerMonth * 1.25 * 0.90 * 4;
                    break;
            }
        } else {
            switch (season) {
                case "Spring":
                case "Autumn":
                case "Summer":
                case "Winter":
                    salary = kmPerMonth * 1.45 * 0.90 * 4;
                    break;
            }
        }
        System.out.printf("%.2f", salary);

    }
}
