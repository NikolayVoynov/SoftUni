import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class E03_Code {
    public static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] firstSequence = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] secondSequence = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        dp = new int[firstSequence.length + 1][secondSequence.length + 1];

        for (int rowIndex = 1; rowIndex <= firstSequence.length; rowIndex++) {
            for (int colIndex = 1; colIndex <= secondSequence.length; colIndex++) {
                if (firstSequence[rowIndex - 1] == secondSequence[colIndex - 1]) {
                    dp[rowIndex][colIndex] = dp[rowIndex - 1][colIndex - 1] + 1;
                } else {
                    dp[rowIndex][colIndex] = Math.max(dp[rowIndex - 1][colIndex], dp[rowIndex][colIndex - 1]);
                }
            }
        }

        ArrayDeque<Integer> longestSubsequence = new ArrayDeque<>();

        int row = firstSequence.length - 1;
        int col = secondSequence.length - 1;

        while (row >= 0 && col >= 0) {
            if (firstSequence[row] == secondSequence[col]) {
                longestSubsequence.push(firstSequence[row]);
                row--;
                col--;

            } else if (row > 0 && col == 0) {
                row--;
            } else if (row == 0 && col > 0) {
                col--;
            } else if (dp[row - 1][col] > dp[row][col - 1]) {
                row--;
            } else {
                col--;
            }
        }


        StringBuilder sb = new StringBuilder();

        while (!longestSubsequence.isEmpty()) {
            sb.append(longestSubsequence.pop()).append(" ");
        }

        System.out.println(sb.toString().trim());
        System.out.println(dp[firstSequence.length][secondSequence.length]);
    }
}
