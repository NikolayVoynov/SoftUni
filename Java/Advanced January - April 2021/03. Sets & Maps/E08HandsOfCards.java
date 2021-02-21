import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E08HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Set<String>> playerCards = new LinkedHashMap<>();

        Map<String, Integer> playerCardsSum = new LinkedHashMap<>();


        while (!input.equals("JOKER")) {
            String[] token = input.split(":\\s+");
            String name = token[0];
            String[] cards = token[1].split(", ");

            playerCards.putIfAbsent(name, new HashSet<>());

            for (String card : cards) {
                playerCards.get(name).add(card);
            }

            input = scanner.nextLine();
        }

        String regex = "(?<power>[0-9]+|[JQKA])(?<type>[CDHS]{1})";
        Pattern pattern = Pattern.compile(regex);

        for (Map.Entry<String, Set<String>> entry : playerCards.entrySet()) {
            int playerScore = 0;

            for (String card : entry.getValue()) {
                Matcher matcher = pattern.matcher(card);

                if (matcher.find()) {
                    String power = matcher.group("power");
                    String type = matcher.group("type");

                    int powerValue = getPower(power);
                    int typeValue = getTypeValue(type);
                    int cardValue = powerValue * typeValue;
                    playerScore += cardValue;
                }

                playerCardsSum.put(entry.getKey(), playerScore);
            }
        }

        for (Map.Entry<String, Integer> entry : playerCardsSum.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


    }

    private static int getTypeValue(String type) {
        int typeValue = 0;

        switch (type) {
            case "C":
                typeValue = 1;
                break;
            case "D":
                typeValue = 2;
                break;
            case "H":
                typeValue = 3;
                break;
            case "S":
                typeValue = 4;
                break;
        }
        return typeValue;
    }

    private static int getPower(String power) {
        int powerInteger = 0;

        switch (power) {
            case "J":
                powerInteger = 11;
                break;
            case "Q":
                powerInteger = 12;
                break;
            case "K":
                powerInteger = 13;
                break;
            case "A":
                powerInteger = 14;
                break;
            default:
                powerInteger = Integer.parseInt(power);
                break;
        }

        return powerInteger;
    }
}
