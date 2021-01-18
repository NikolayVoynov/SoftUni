import java.util.Scanner;

public class PCStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceProcessorDollars = Double.parseDouble(scanner.nextLine());
        double priceVideoCardDollars = Double.parseDouble(scanner.nextLine());
        double priceRAMDollars = Double.parseDouble(scanner.nextLine());
        int countRAM = Integer.parseInt(scanner.nextLine());
        double discount = Double.parseDouble(scanner.nextLine());


        double priceProcessorLeva = priceProcessorDollars * 1.57;
        double priceVideoCardLeva = priceVideoCardDollars * 1.57;

        double priceProcessorDiscount = priceProcessorLeva * (1 - discount);
        double priceVideoCardDiscount = priceVideoCardLeva * (1 - discount);
        double priceRAMLeva = priceRAMDollars * countRAM * 1.57;

        double totalPrice = priceProcessorDiscount + priceVideoCardDiscount + priceRAMLeva;

        System.out.printf("Money needed - %.2f leva.", totalPrice);

    }
}
