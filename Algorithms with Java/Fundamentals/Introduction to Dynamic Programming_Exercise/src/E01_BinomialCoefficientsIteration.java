import java.util.Scanner;

public class E01_BinomialCoefficientsIteration {

    public static long[][] memory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());

        memory = new long[n + 1][k + 1];

        for (int r = 0; r <= n; r++) {
            for (int c = 0; c <= Math.min(r, k); c++) {
                if (c == 0 || c == r) {
                    memory[r][c] = 1;
                } else {
                    memory[r][c] = memory[r - 1][c] + memory[r - 1][c - 1];
                }
            }
        }

        System.out.println(memory[n][k]);
    }
}
