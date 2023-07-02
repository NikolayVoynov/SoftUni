import java.util.Scanner;

public class E01_BitcoinMiners {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int x = Integer.parseInt(scanner.nextLine());

        System.out.println(combinationsCount(n, x));
    }

    private static int combinationsCount(int n, int x) {
        if (x > n) {
           return 0;
        }

        if (x == 0 || x == n) {
            return 1;
        }

        return combinationsCount(n - 1, x - 1) + combinationsCount(n - 1, x);
    }
}
