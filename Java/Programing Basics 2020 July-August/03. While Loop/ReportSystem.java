import java.util.Scanner;

public class ReportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int moneyNeeded = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();

        int counter = 0;
        int counterCash = 0;
        int counterCard = 0;

        double sumCash = 0;
        double sumCard = 0;

        double averageCS = 0;
        double averageCC = 0;

        double moneyCollected = 0;

        while (!command.equals("End")) {
            int input = Integer.parseInt(command);
            counter++;

            if (counter % 2 != 0) {
                if (input > 100) {
                    System.out.println("Error in transaction!");
                } else {
                    counterCash++;
                    sumCash += input;
                    System.out.println("Product sold!");
                }
            } else {
                if (input < 10) {
                    System.out.println("Error in transaction!");
                } else {
                    counterCard++;
                    sumCard += input;
                    System.out.println("Product sold!");
                }
            }
            moneyCollected = sumCash + sumCard;

            if (moneyCollected >= moneyNeeded) {
                averageCS = sumCash / counterCash;
                averageCC = sumCard / counterCard;

                System.out.printf("Average CS: %.2f%n", averageCS);
                System.out.printf("Average CC: %.2f", averageCC);

                return;
            }

            command = scanner.nextLine();
        }

        System.out.println("Failed to collect required money for charity.");
    }
}
