import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String destination = scanner.nextLine();

        while (!destination.equals("End")) {
            double budget = Double.parseDouble(scanner.nextLine());
            double totalSavedMoney = 0;

            while (totalSavedMoney < budget) {
                double currentSavedMoney = Double.parseDouble(scanner.nextLine());
                totalSavedMoney += currentSavedMoney;
            }

            System.out.printf("Going to %s!%n", destination);


            destination = scanner.nextLine();
        }
    }
}
