import java.util.Scanner;

public class BikeRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int juniors = Integer.parseInt(scanner.nextLine());
        int seniors = Integer.parseInt(scanner.nextLine());
        String race = scanner.nextLine();

        double totalMoney = 0;



        switch (race) {
            case "trail":
                totalMoney = (juniors * 5.5 + seniors * 7) * (1 - 0.05);
                break;
            case "cross-country":
                if (juniors + seniors >= 50) {
                    totalMoney = (juniors * 8 + seniors * 9.5) * (1 - 0.05) * (1 - 0.25);
                } else {
                    totalMoney = (juniors * 8 + seniors * 9.5) * (1 - 0.05);
                }
                break;
            case "downhill":
                totalMoney = (juniors * 12.25 + seniors * 13.75) * (1 - 0.05);
                break;
            case "road":
                totalMoney = (juniors * 20 + seniors * 21.50) * (1 - 0.05);
                break;
        }
        System.out.printf("%.2f", totalMoney);
    }
}