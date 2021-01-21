import java.util.Scanner;

public class L05Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        double price = 0;

        switch (product) {
            case "coffee":
                calculatePrice(1.50, quantity);
                break;
            case "water":
                calculatePrice(1.00, quantity);
                break;
            case "coke":
                calculatePrice(1.40, quantity);
                break;
            case "snacks":
                calculatePrice(2.00, quantity);
                break;
        }
    }

    public static void calculatePrice(double price, int quantity) {
        double priceTotal = price * quantity;
        System.out.printf("%.2f", priceTotal);
    }
}
