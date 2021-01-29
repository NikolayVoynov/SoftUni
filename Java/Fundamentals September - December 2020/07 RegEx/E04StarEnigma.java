import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E04StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        int counterAttacked = 0;
        int counterDestroyed = 0;

        String countRegex = "(?i)[star]";
        Pattern countPattern = Pattern.compile(countRegex);

        String validRegex = "@(?<name>[A-Za-z]+)[^@\\-!:>]*:(?<population>\\d+)[^@\\-!:>]*!(?<type>[A|D])![^@\\-!:>]*->(?<soldiers>\\d+)";
        Pattern validPattern = Pattern.compile(validRegex);

        for (int i = 0; i < n; i++) {
            String encryptMessage = scanner.nextLine();
            Matcher countMatcher = countPattern.matcher(encryptMessage);
            int counter = 0;

            while (countMatcher.find()) {
                counter++;
            }

            StringBuilder decryptedMessage = new StringBuilder();

            for (int j = 0; j < encryptMessage.length(); j++) {
                int ascii = encryptMessage.charAt(j);
                int newAscii = ascii - counter;
                char newSymbol = (char) newAscii;

                decryptedMessage.append(newSymbol);
            }

            Matcher validMatcher = validPattern.matcher(decryptedMessage.toString());

            while (validMatcher.find()) {
                String name = validMatcher.group("name");
                String type = validMatcher.group("type");

                if (type.equals("A")) {
                    counterAttacked++;
                    attackedPlanets.add(name);
                } else {
                    counterDestroyed++;
                    destroyedPlanets.add(name);
                }
            }
        }

        System.out.printf("Attacked planets: %d%n", counterAttacked);

        Collections.sort(attackedPlanets);
        attackedPlanets.stream().forEach(p-> System.out.printf("-> %s%n", p));

        System.out.printf("Destroyed planets: %d%n", counterDestroyed);

        Collections.sort(destroyedPlanets);
        destroyedPlanets.stream().forEach(p-> System.out.printf("-> %s%n", p));

    }
}
