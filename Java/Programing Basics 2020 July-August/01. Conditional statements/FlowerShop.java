import java.util.Scanner;

public class FlowerShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countMagnolii = Integer.parseInt(scanner.nextLine());
        int countZumbuli = Integer.parseInt(scanner.nextLine());
        int countRoses = Integer.parseInt(scanner.nextLine());
        int countCactus = Integer.parseInt(scanner.nextLine());
        double pricePresent = Double.parseDouble(scanner.nextLine());

        double totalIncome = (countMagnolii * 3.25 + countZumbuli * 4 + countRoses * 3.5 + countCactus * 8) * 0.95;

        if (totalIncome >= pricePresent) {
            double extraMoney = Math.floor(totalIncome - pricePresent);
            System.out.printf("She is left with %.0f leva.",extraMoney);
        } else {
            double deficientMoney = Math.ceil(pricePresent - totalIncome);
            System.out.printf("She will have to borrow %.0f leva.", deficientMoney);
        }
    }
}
