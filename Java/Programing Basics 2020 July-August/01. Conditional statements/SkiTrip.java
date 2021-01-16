import java.util.Scanner;

public class SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int nights = days - 1;
        String roomType = scanner.nextLine();
        String evaluation = scanner.nextLine();
        double price = 0;

        if (evaluation.equals("positive")) {
        if (days < 10) {
            switch (roomType) {
                case "room for one person":
                    price = nights * 18.00 * 1.25;
                    System.out.printf("%.2f", price);
                    break;
                case "apartment":
                    price = nights * 25.00 * 0.70 * 1.25;
                    System.out.printf("%.2f", price);
                    break;
                case "president apartment":
                    price = nights * 35.00 * 0.90 * 1.25;
                    System.out.printf("%.2f", price);
                    break;
            }
        } else if (days <= 15) {
            switch (roomType) {
                case "room for one person":
                    price = nights * 18.00 * 1.25;
                    System.out.printf("%.2f", price);
                    break;
                case "apartment":
                    price = nights * 25.00 * 0.65 * 1.25;
                    System.out.printf("%.2f", price);
                    break;
                case "president apartment":
                    price = nights * 35.00 * 0.85 * 1.25;
                    System.out.printf("%.2f", price);
                    break;
            }
        } else if (days > 15) {
            switch (roomType) {
                case "room for one person":
                    price = nights * 18.00 * 1.25;
                    System.out.printf("%.2f", price);
                    break;
                case "apartment":
                    price = nights * 25.00 * 0.50 * 1.25;
                    System.out.printf("%.2f", price);
                    break;
                case "president apartment":
                    price = nights * 35.00 * 0.80 * 1.25;
                    System.out.printf("%.2f", price);
                    break;
            }
        }

        } else if (evaluation.equals("negative")) {
            if (days < 10) {
                switch (roomType) {
                    case "room for one person":
                        price = nights * 18.00 * 0.90;
                        System.out.printf("%.2f", price);
                        break;
                    case "apartment":
                        price = nights * 25.00 * 0.70 * 0.90;
                        System.out.printf("%.2f", price);
                        break;
                    case "president apartment":
                        price = nights * 35.00 * 0.90 * 0.90;
                        System.out.printf("%.2f", price);
                        break;
                }
            } else if (days <= 15) {
                switch (roomType) {
                    case "room for one person":
                        price = nights * 18.00 * 0.90;
                        System.out.printf("%.2f", price);
                        break;
                    case "apartment":
                        price = nights * 25.00 * 0.65 * 0.90;
                        System.out.printf("%.2f", price);
                        break;
                    case "president apartment":
                        price = nights * 35.00 * 0.85 * 0.90;
                        System.out.printf("%.2f", price);
                        break;
                }
            } else if (days > 15) {
                switch (roomType) {
                    case "room for one person":
                        price = nights * 18.00 * 0.90;
                        System.out.printf("%.2f", price);
                        break;
                    case "apartment":
                        price = nights * 25.00 * 0.50 * 0.90;
                        System.out.printf("%.2f", price);
                        break;
                    case "president apartment":
                        price = nights * 35.00 * 0.80 * 0.90;
                        System.out.printf("%.2f", price);
                        break;
                }
            }

        }
    }
}