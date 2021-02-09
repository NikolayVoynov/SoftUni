import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ME03DeckOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> cardsList = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split(", ");

            String command = tokens[0];

            switch (command) {
                case "Add":
                    String cardName = tokens[1];
                    if (cardsList.contains(cardName)) {
                        System.out.println("Card is already bought");
                    } else {
                        cardsList.add(cardName);
                        System.out.println("Card successfully bought");
                    }
                    break;
                case "Remove":
                    cardName = tokens[1];
                    if (cardsList.contains(cardName)) {
                        System.out.println("Card successfully sold");
                        cardsList.remove(cardName);
                    } else {
                        System.out.println("Card not found");
                    }
                    break;
                case "Remove At":
                    int index = Integer.parseInt(tokens[1]);

                    if (index < 0 || index >= cardsList.size()) {
                        System.out.println("Index out of range");
                    } else {
                        cardsList.remove(index);
                        System.out.println("Card successfully sold");
                    }

                    break;
                case "Insert":
                    index = Integer.parseInt(tokens[1]);
                    cardName = tokens[2];

                    if (index < 0 || index >= cardsList.size()) {
                        System.out.println("Index out of range");

                    } else {

                        if (!cardsList.contains(cardName)) {
                            cardsList.add(index, cardName);
                            System.out.println("Card successfully bought");
                        } else {
                            System.out.println("Card is already bought");
                        }

                    }

                    break;
            }

        }

        for (int i = 0; i < cardsList.size() - 1; i++) {
            System.out.print(cardsList.get(i) + ", ");
        }

        System.out.print(cardsList.get(cardsList.size() - 1));

    }
}
