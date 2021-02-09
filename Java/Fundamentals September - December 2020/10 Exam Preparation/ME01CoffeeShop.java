import java.util.Scanner;

public class ME01CoffeeShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int orders = Integer.parseInt(scanner.nextLine());

        double totalPrice = 0;

        for (int i = 0; i < orders; i++) {
            double pricePerCapsule = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsuleCount = Integer.parseInt(scanner.nextLine());

            double priceCoffee = (days * capsuleCount) * pricePerCapsule;
            System.out.printf("The price for the coffee is: $%.2f%n", priceCoffee);

            totalPrice += priceCoffee;
        }

        System.out.printf("Total: $%.2f", totalPrice);

    }
}
