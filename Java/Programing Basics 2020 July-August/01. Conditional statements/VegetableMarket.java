import java.util.Scanner;

public class VegetableMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceVegetables = Double.parseDouble(scanner.nextLine());
        double priceFruits = Double.parseDouble(scanner.nextLine());
        double kgVegetables = Double.parseDouble(scanner.nextLine());
        double kgFruits = Double.parseDouble(scanner.nextLine());

        double totalPriceEuro = (priceVegetables * kgVegetables + priceFruits * kgFruits) / 1.94;

        System.out.printf("%.2f", totalPriceEuro);


    }
}
