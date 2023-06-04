import java.util.*;
import java.util.stream.Collectors;

public class L04_SumOfCoins {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(in.nextLine().substring(5));


        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);

        for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
            System.out.println(usedCoin.getKey() + " -> " + usedCoin.getValue());
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        Arrays.sort(coins);
        List<Integer> sortedCoins = Arrays.stream(coins).boxed().collect(Collectors.toList());
        Collections.reverse(sortedCoins);

        Map<Integer, Integer> chosenCoins = new LinkedHashMap<>();
        int currentSum = 0;
        int coinIndex = 0;

        while (currentSum < targetSum && coinIndex < sortedCoins.size()) {
            int currentCoinValue = sortedCoins.get(coinIndex);
            int remainingSum = targetSum - currentSum;
            int numberCoinsToTake = remainingSum / currentCoinValue;

            if (numberCoinsToTake > 0) {
                chosenCoins.put(currentCoinValue, numberCoinsToTake);
                currentSum = currentSum + numberCoinsToTake * currentCoinValue;
            }

            coinIndex++;
        }

        return chosenCoins;
    }
}