import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double moneyVacation = Double.parseDouble(scanner.nextLine());
        double moneyCurrent = Double.parseDouble(scanner.nextLine());

        int daysCounter = 0;
        int daysSpend = 0;

        while (moneyCurrent < moneyVacation && daysSpend < 5) {
            String command = scanner.nextLine();
            double money = Double.parseDouble(scanner.nextLine());
            daysCounter++;

            if (command.equals("save")) {
                moneyCurrent += money;
                daysSpend = 0;
            } else if (command.equals("spend")){
                moneyCurrent -= money;
                daysSpend++;
                if (moneyCurrent < 0) {
                    moneyCurrent = 0;
                }
            }
        }
        if (daysSpend == 5) {
            System.out.println("You can't save the money.");
            System.out.println(daysCounter);
        }
        if (moneyCurrent >= moneyVacation) {
            System.out.printf("You saved the money for %d days.", daysCounter);
        }
    }
}