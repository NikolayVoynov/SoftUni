import java.util.Scanner;

public class EasterBakery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceFlourKG = Double.parseDouble(scanner.nextLine());
        double kgFlour = Double.parseDouble(scanner.nextLine());
        double kgSugar = Double.parseDouble(scanner.nextLine());
        int countSetEggs = Integer.parseInt(scanner.nextLine());
        int packagesYeast = Integer.parseInt(scanner.nextLine());

        double priceFlour = priceFlourKG * kgFlour;
        double priceSugar = kgSugar * priceFlourKG * 0.75;
        double priceEggs = countSetEggs * priceFlourKG * 1.1;
        double priceYeast = packagesYeast * priceFlourKG * 0.75 * 0.2;

        double totalPrice = priceFlour + priceSugar + priceEggs + priceYeast;

        System.out.printf("%.2f", totalPrice);

    }
}
