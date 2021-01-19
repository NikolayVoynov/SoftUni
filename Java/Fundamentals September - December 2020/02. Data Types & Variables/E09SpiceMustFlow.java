import java.util.Scanner;

public class E09SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());
        int days = 0;
        int totalYield = 0;

        while (startingYield >= 100) {
            days++;
            totalYield += (startingYield - 26);

            startingYield -= 10;
        }

        if (totalYield > 0) {
            totalYield -= 26;
        }

        System.out.println(days);
        System.out.println(totalYield);
    }
}
