import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E03_BitcoinTransactions {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstSeq = scanner.nextLine().split("\\s+");
        String[] secondSeq = scanner.nextLine().split("\\s+");

        int n = firstSeq.length;
        int m = secondSeq.length;

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = 0;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (firstSeq[i].equals(secondSeq[j])) {
                    dp[i][j] = 1;
                }
            }
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (dp[i][j] == 1) {
                    result.add(secondSeq[j]);
                }
            }
        }

        String res = String.join(" ", result);
        System.out.println("[" + res + "]");
    }
}
