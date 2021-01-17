import java.util.Scanner;

public class CarToGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        double price = 0;
        double priceJeep = 0;

        if (budget <= 100) {
            System.out.println("Economy class");
            switch (season) {
                case "Summer":
                    price = budget * 0.35;
                    System.out.printf("Cabrio - %.2f", price);
                    break;
                case "Winter":
                    price = budget * 0.65;
                    System.out.printf("Jeep - %.2f", price);
                    break;
            }
        } else if (budget <= 500) {
            System.out.println("Compact class");
            switch (season) {
                case "Summer":
                    price = budget * 0.45;
                    System.out.printf("Cabrio - %.2f", price);
                    break;
                case "Winter":
                    price = budget * 0.80;
                    System.out.printf("Jeep - %.2f", price);
                    break;
            }
        } else {
            System.out.println("Luxury class");
            switch (season) {
                case "Summer":
                case "Winter":
                    price = budget * 0.90;
                    System.out.printf("Jeep - %.2f", price);
                    break;
            }
        }
    }
}
