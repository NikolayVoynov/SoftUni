import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());
        int counterCoins = 0;

        money = Math.round(money * 100);

        while (money > 0) {
            if (money >= 200) {
                money -= 200;
                counterCoins++;
            } else if (money >= 100) {
                money -= 100;
                counterCoins++;
            } else if (money >= 50) {
                money -= 50;
                counterCoins++;
            } else if (money >= 20) {
                money -= 20;
                counterCoins++;
            } else if (money >= 10) {
                money -= 10;
                counterCoins++;
            } else if (money >= 5) {
                money -= 5;
                counterCoins++;
            } else if (money >= 2) {
                money -= 2;
                counterCoins++;
            } else if (money >= 1) {
               money -= 1;
               counterCoins++;
            }
        }
        System.out.println(counterCoins);
    }
}
