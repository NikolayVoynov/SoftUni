import java.util.Scanner;

public class SuppliesForSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberPencils = Integer.parseInt(scanner.nextLine());
        int numberMarkers = Integer.parseInt(scanner.nextLine());
        double sprayLitres = Double.parseDouble(scanner.nextLine());
        int discount = Integer.parseInt(scanner.nextLine());

        double neededMoney = numberPencils * 5.80 + numberMarkers * 7.20 + sprayLitres * 1.20;
        double totalMoneyWithDiscount = neededMoney * (100 - discount) / 100;

        System.out.printf("%.3f", totalMoneyWithDiscount);

    }
}

