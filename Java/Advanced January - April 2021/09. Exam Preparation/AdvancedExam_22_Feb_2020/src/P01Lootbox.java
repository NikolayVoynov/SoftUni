import java.util.*;
import java.util.stream.Collectors;

public class P01Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstLootQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondLootStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .forEach(e->secondLootStack.push(e));

        List<Integer> claimedItems = new ArrayList<>();

        while (!firstLootQueue.isEmpty() && !secondLootStack.isEmpty()) {
            int firstLootCurrent = firstLootQueue.peek();
            int secondLootCurrent = secondLootStack.peek();
            int sum = firstLootCurrent + secondLootCurrent;

            if (sum % 2 == 0) {
                claimedItems.add(sum);
                firstLootQueue.poll();
                secondLootStack.pop();
            } else {
                secondLootStack.pop();
                firstLootQueue.offer(secondLootCurrent);
            }
        }

        if (firstLootQueue.isEmpty()) {
            System.out.println("First lootbox is empty");
        }

        if (secondLootStack.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }

        int sumClaimedItems = claimedItems.stream().mapToInt(Integer::intValue).sum();

        if (sumClaimedItems >= 100) {
            System.out.println("Your loot was epic! Value: " + sumClaimedItems);
        } else {
            System.out.println("Your loot was poor... Value: " + sumClaimedItems);
        }
    }
}
