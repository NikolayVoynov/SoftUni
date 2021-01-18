import java.util.Scanner;

public class ChangeBureau {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bitcoin = Integer.parseInt(scanner.nextLine());
        double chineseYuan = Double.parseDouble(scanner.nextLine());
        double commission = Double.parseDouble(scanner.nextLine());

        double moneyEuro = (bitcoin * 1168 + chineseYuan * 0.15 * 1.76) / 1.95;

        double totalMoneyEuro = moneyEuro * (1 - (commission / 100));

        System.out.printf("%.2f", totalMoneyEuro);

    }
}
