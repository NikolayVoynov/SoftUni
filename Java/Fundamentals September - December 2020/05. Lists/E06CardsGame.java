import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E06CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> secondPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        while (firstPlayerCards.size() > 0 && secondPlayerCards.size() > 0) {
            if (firstPlayerCards.get(0) > secondPlayerCards.get(0)) {
                firstPlayerCards.add(firstPlayerCards.get(0));
                firstPlayerCards.add(secondPlayerCards.get(0));
                firstPlayerCards.remove(0);
                secondPlayerCards.remove(0);
            } else if (firstPlayerCards.get(0) < secondPlayerCards.get(0)) {
                secondPlayerCards.add(secondPlayerCards.get(0));
                secondPlayerCards.add(firstPlayerCards.get(0));
                firstPlayerCards.remove(0);
                secondPlayerCards.remove(0);
            } else {
                firstPlayerCards.remove(0);
                secondPlayerCards.remove(0);
            }
        }

        int sum = 0;

        if (firstPlayerCards.size() == 0) {
            for (Integer secondPlayerCard : secondPlayerCards) {
                sum += secondPlayerCard;
            }
            System.out.printf("Second player wins!" + " Sum: %d", sum);

        } else {
            for (Integer firstPlayerCard : firstPlayerCards) {
                sum += firstPlayerCard;
            }
            System.out.printf("First player wins!" + " Sum: %d", sum);
        }
    }
}
