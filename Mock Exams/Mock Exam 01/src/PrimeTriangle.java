import java.util.Scanner;

public class PrimeTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= input; i++) {

            if (isPrime(i)) {

                for (int j = 1; j <= i; j++) {

                    if (isPrime(j)) {
                        System.out.print(1);
                    } else {
                        System.out.print(0);
                    }
                }
                System.out.println();
            }
        }


    }

    private static boolean isPrime(int n) {

        if (n < 1) {
            return false;
        } else if (n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;

    }
}
