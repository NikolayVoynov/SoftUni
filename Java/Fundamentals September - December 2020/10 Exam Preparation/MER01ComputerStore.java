import java.util.Scanner;

public class MER01ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double totalPriceWithoutTaxes = 0;
        double totalTaxes = 0;



        while (!input.equals("special") && !input.equals("regular")) {
            double price = Double.parseDouble(input);

            if (price < 0) {
                System.out.println("Invalid price!");
            } else {
                totalPriceWithoutTaxes += price;
                totalTaxes += price * 0.2;
            }
            input = scanner.nextLine();
        }

        double totalPrice = totalPriceWithoutTaxes + totalTaxes;

        if (totalPrice == 0) {
            System.out.println("Invalid order!");

        } else {
            switch (input) {
                case "special":
                    double specialTotalPrice = totalPrice * 0.9;
                    System.out.println("Congratulations you've just bought a new computer!");
                    System.out.printf("Price without taxes: %.2f$%n", totalPriceWithoutTaxes);
                    System.out.printf("Taxes: %.2f$%n", totalTaxes);
                    System.out.println("-----------");
                    System.out.printf("Total price: %.2f$", specialTotalPrice);
                    break;
                case "regular":
                    System.out.println("Congratulations you've just bought a new computer!");
                    System.out.printf("Price without taxes: %.2f$%n", totalPriceWithoutTaxes);
                    System.out.printf("Taxes: %.2f$%n", totalTaxes);
                    System.out.println("-----------");
                    System.out.printf("Total price: %.2f$", totalPrice);
                    break;
            }

        }




    }
}
