import java.util.*;
import java.util.stream.Collectors;

public class P01MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBoxQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));


        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .forEach(e->secondBoxStack.push(e));

        List<Integer> claimedItems = new ArrayList<>();

        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {
            int firstBoxCurrent = firstBoxQueue.peek();
            int secondBoxCurrent = secondBoxStack.peek();
            int sum = firstBoxCurrent + secondBoxCurrent;

            if (sum % 2 == 0) {
                claimedItems.add(sum);
                firstBoxQueue.poll();
                secondBoxStack.pop();
            } else {
                secondBoxStack.pop();
                firstBoxQueue.offer(secondBoxCurrent);
            }
        }

        if (firstBoxQueue.isEmpty()) {
            System.out.println("First magic box is empty.");
        }

        if (secondBoxStack.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }

        int sumClaimedItems = claimedItems.stream().mapToInt(Integer::intValue).sum();

        if (sumClaimedItems >= 90) {
            System.out.println("Wow, your prey was epic! Value: " + sumClaimedItems);
        } else {
            System.out.println("Poor prey... Value: " + sumClaimedItems);
        }

    }
}
