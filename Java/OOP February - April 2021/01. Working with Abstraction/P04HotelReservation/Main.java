package P04HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] information = scanner.nextLine().split("\\s+");
        double pricePerDay = Double.parseDouble(information[0]);
        int days = Integer.parseInt(information[1]);


        PriceCalculator calculator =
                new PriceCalculator(pricePerDay, days, Season.valueOf(information[2]), Discount.valueOf(information[3]));

        System.out.printf("%.2f%n", calculator.calculatePrice());
    }
}
