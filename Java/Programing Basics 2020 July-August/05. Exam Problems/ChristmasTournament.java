import java.util.Scanner;

public class ChristmasTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());


        double totalRaisedMoney = 0;

        int daysWin = 0;
        int daysLose = 0;

        for (int i = 1; i <= days; i++) {

            double raisedMoneyPerDay = 0;
            int win = 0;
            int lose = 0;

            String input = scanner.nextLine();

            while (!input.equals("Finish")) {
                String result = scanner.nextLine();

                if (result.equals("win")) {
                    raisedMoneyPerDay += 20;
                    win++;
                } else {
                    lose++;
                }

                input = scanner.nextLine();
            }

            if (win > lose) {
                raisedMoneyPerDay *= 1.1;
                daysWin++;
            } else {
                daysLose++;
            }
            totalRaisedMoney += raisedMoneyPerDay;
        }

        if (daysWin > daysLose) {
            totalRaisedMoney *= 1.2;
            System.out.printf("You won the tournament! Total raised money: %.2f", totalRaisedMoney);
        } else {
            System.out.printf("You lost the tournament! Total raised money: %.2f", totalRaisedMoney);
        }
    }
}
