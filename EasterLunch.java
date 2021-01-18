import java.util.Scanner;

public class EasterLunch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countEasterCake = Integer.parseInt(scanner.nextLine());
        int countSetEggs = Integer.parseInt(scanner.nextLine());
        int cookies = Integer.parseInt(scanner.nextLine());

        double priceCake = countEasterCake * 3.2;
        double priceEggs = countSetEggs * 4.35;
        double pricePaint = countSetEggs * 12 * 0.15;
        double priceCookies = cookies * 5.4;

        double totalPrice = priceCake + priceEggs + priceCookies + pricePaint;

        System.out.printf("%.2f", totalPrice);
    }
}
