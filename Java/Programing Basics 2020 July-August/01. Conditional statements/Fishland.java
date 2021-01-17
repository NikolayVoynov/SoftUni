import java.util.Scanner;

public class Fishland {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceMackerel = Double.parseDouble(scanner.nextLine());
        double priceSprat = Double.parseDouble(scanner.nextLine());
        double kgBonito = Double.parseDouble(scanner.nextLine());
        double kgScad = Double.parseDouble(scanner.nextLine());
        double kgMussels = Integer.parseInt(scanner.nextLine());

        double priceTotalBonito = kgBonito * (priceMackerel * 0.6 + priceMackerel);
        double priceTotalScad = kgScad * (priceSprat * 0.8 + priceSprat);
        double priceTotalMussels = kgMussels * 7.5;

        double totalPrice = priceTotalBonito + priceTotalScad + priceTotalMussels;

        System.out.printf("%.2f", totalPrice);

        }
    }