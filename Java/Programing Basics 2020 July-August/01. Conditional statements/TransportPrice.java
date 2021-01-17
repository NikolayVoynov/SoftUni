import java.io.Console;
import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String partOfDay = scanner.nextLine();

        if (partOfDay.equals("day")) {
            if (n >= 100) {
                double priceTrainDay = 0.06 * n;
                System.out.printf("%.2f", priceTrainDay);
            } else if (n >= 20) {
                double priceBusDay = 0.09 * n;
                System.out.printf("%.2f", priceBusDay);
            } else {
                double priceTaxiDay = 0.79 * n + 0.7;
                System.out.printf("%.2f", priceTaxiDay);
            }
        } else if (partOfDay.equals("night")) {
            if (n >= 100) {
                double priceTrainNight = 0.06 * n;
                System.out.printf("%.2f", priceTrainNight);
            } else if (n >= 20) {
                double priceBusNight = 0.09 * n;
                System.out.printf("%.2f", priceBusNight);
            } else {
                double priceTaxiNight = 0.9 * n + 0.7;
                System.out.printf("%.2f", priceTaxiNight);
            }
        }

    }
}
