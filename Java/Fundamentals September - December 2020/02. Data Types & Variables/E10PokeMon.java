import java.util.Scanner;

public class E10PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int y = Integer.parseInt(scanner.nextLine());

        int counterTargets = 0;
        double halfN = n * 0.5;

        while (n >= m) {
            counterTargets++;
            n -= m;

            if (n == halfN) {
                if (y > 0) {
                    n /= y;
                }

            }

        }

        System.out.println(n);
        System.out.println(counterTargets);


    }
}
