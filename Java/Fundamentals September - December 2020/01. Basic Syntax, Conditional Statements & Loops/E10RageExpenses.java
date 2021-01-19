import java.util.Scanner;

public class E10RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int lostGames = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        double expenses = 0;
        int counterDisplay = 0;

        for (int i = 1; i <= lostGames; i++) {

            if ((i % 2 == 0) && (i % 3 == 0)) {
                counterDisplay++;
                expenses += (mousePrice + headsetPrice + keyboardPrice);

                if (counterDisplay % 2 == 0) {
                    expenses += displayPrice;
                }
            } else if (i % 2 == 0) {
                expenses += headsetPrice;
            } else if (i % 3 == 0) {
                expenses += mousePrice;
            }
        }

        System.out.printf("Rage expenses: %.2f lv.", expenses);
    }
}
