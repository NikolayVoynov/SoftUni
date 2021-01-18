import java.util.Scanner;

public class EasterParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int guests = Integer.parseInt(scanner.nextLine());
        double plate = Double.parseDouble(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());

        double spendMoney = 0;
        double priceCake = budget * 0.1;

        if (guests > 20) {
            plate *= 0.75;
            spendMoney = guests * plate + priceCake;
        } else if (guests > 15) {
            plate *= 0.8;
            spendMoney = guests * plate + priceCake;
        } else if (guests >= 10) {
            plate *= 0.85;
            spendMoney = guests * plate + priceCake;
        } else {
            spendMoney = guests * plate + priceCake;
        }

        if (budget >= spendMoney) {
            System.out.printf("It is party time! %.2f leva left.", Math.abs(budget - spendMoney));
        } else {
            System.out.printf("No party! %.2f leva needed.", Math.abs(budget - spendMoney));
        }

    }
}
