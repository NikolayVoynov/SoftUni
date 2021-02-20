import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet<Integer> secondDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        int round = 1;

        while (round < 50 && !firstDeck.isEmpty() && !secondDeck.isEmpty()) {
            round++;

            int firstNumber = firstDeck.iterator().next();
            int secondNumber = secondDeck.iterator().next();
            firstDeck.remove(firstNumber);
            secondDeck.remove(secondNumber);

            if (firstNumber > secondNumber) {
                firstDeck.add(firstNumber);
                firstDeck.add(secondNumber);
            } else if (secondNumber > firstNumber) {
                secondDeck.add(secondNumber);
                secondDeck.add(firstNumber);
            }
        }

        if (secondDeck.isEmpty() || firstDeck.size() > secondDeck.size()) {
            System.out.println("First player win!");
        } else if (firstDeck.isEmpty() || secondDeck.size() > firstDeck.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw");
        }
    }

}
