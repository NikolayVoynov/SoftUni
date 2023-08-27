import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E01_TimberMaxDilemma {
    public static int[] bestPrices;
    public static int[] prices;
    public static int[] prevIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] inputPrices = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int length = Integer.parseInt(reader.readLine());

        prices = new int[length + 1];

        prices[0] = 0;

        for (int i = 1; i <= length; i++) {
            prices[i] = inputPrices[i - 1];
        }

        bestPrices = new int[length + 1];
        prevIndex = new int[length + 1];

        int maxRevenue = solveTimberMaxDilemma(length);

        System.out.println(maxRevenue);
    }

    private static int solveTimberMaxDilemma(int length) {
        if (length == 0) {
            return 0;
        }

        if (bestPrices[length] != 0) {
            return bestPrices[length];
        }

        int currentBest = bestPrices[length];

        for (int i = 1; i <= length; i++) {
            currentBest = Math.max(currentBest, prices[i] + solveTimberMaxDilemma(length - i));

            if (currentBest > bestPrices[length]) {
                bestPrices[length] = currentBest;
                prevIndex[length] = i;
            }
        }


        return bestPrices[length];
    }
}