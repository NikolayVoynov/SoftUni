import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ME03GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> validGames = new HashMap<>();
        validGames.put("OutFall 4", 39.99);
        validGames.put("CS: OG", 15.99);
        validGames.put("Zplinter Zell", 19.99);
        validGames.put("Honored 2", 59.99);
        validGames.put("RoverWatch", 29.99);
        validGames.put("RoverWatch Origins Edition", 39.99);

        double currentBalance = Double.parseDouble(scanner.nextLine());
        double spentMoney = 0;
        boolean outOfMoney = false;
        String game = "";

        while (!"Game Time".equals(game = scanner.nextLine())) {
            if (validGames.containsKey(game)) {

                if (currentBalance >= validGames.get(game)) {
                    currentBalance -= validGames.get(game);
                    spentMoney += validGames.get(game);
                    System.out.printf("Bought %s%n", game);
                } else {
                    System.out.println("Too Expensive");
                }

            } else {
                System.out.println("Not Found");
            }

            if (currentBalance == 0) {
                System.out.println("Out of money!");
                outOfMoney = true;
                break;
            }

        }

        if (!outOfMoney) {
            System.out.println(String.format("Total spent: $%.2f. Remaining: $%.2f", spentMoney, currentBalance));
        }


    }
}
