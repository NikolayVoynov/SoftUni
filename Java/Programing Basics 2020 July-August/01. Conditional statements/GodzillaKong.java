import java.util.Scanner;

public class GodzillaKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int countExtra = Integer.parseInt(scanner.nextLine());
        double priceCostumePerExtra = Double.parseDouble(scanner.nextLine());
        double decor = budget * 0.1;
        double totalSum = 0;
        double deficientMoney = 0;
        double extraMoney = 0;

        if (countExtra <= 150) {
            totalSum = decor + countExtra * priceCostumePerExtra;
        } else {
            totalSum = decor + countExtra * priceCostumePerExtra * 0.9;
        }

        if (totalSum > budget) {
            deficientMoney = totalSum - budget;
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", deficientMoney);
        } else {
            extraMoney = budget - totalSum;
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", extraMoney);
        }

    }
}
