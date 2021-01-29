import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E05NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String healthRegex = "[^0-9+\\-*\\/.]";
        Pattern healthPattern = Pattern.compile(healthRegex);

        String damageRegex = "[+|\\-]?\\d+\\.?\\d*";
        Pattern damagePattern = Pattern.compile(damageRegex);

        String regexMultiplyDivide = "[*|\\/]";
        Pattern patternMultiplyDivide = Pattern.compile(regexMultiplyDivide);

        String[] input = scanner.nextLine().split(",\\s*");

        Map<String, String> demons = new TreeMap<>();

        for (int i = 0; i < input.length; i++) {
            String name = input[i];
            int health = 0;
            double damage = 0;

            Matcher healthMatcher = healthPattern.matcher(name);

            StringBuilder healthStr = new StringBuilder();

            while (healthMatcher.find()) {
                healthStr.append(healthMatcher.group());
            }

            for (int j = 0; j < healthStr.length(); j++) {
                int ascii = healthStr.charAt(j);
                health += ascii;
            }

            Matcher damageMatcher = damagePattern.matcher(name);

            while (damageMatcher.find()) {
                damage += Double.parseDouble(damageMatcher.group());
            }

            Matcher matcherMultiplyDivide = patternMultiplyDivide.matcher(name);

            while (matcherMultiplyDivide.find()) {
                String symbol = matcherMultiplyDivide.group();

                switch (symbol) {
                    case "*":
                        damage *= 2;
                        break;
                    case "/":
                        damage /= 2;
                        break;
                }
            }


            String healthFinal = "" + health;
            String damageFinal = String.format("%.2f", damage);
            String healthAndDamage = healthFinal + " health, " + damageFinal +" damage";

            demons.put(name, healthAndDamage);

        }

        demons.entrySet().forEach(e -> {

            System.out.printf("%s - %s%n", e.getKey(), e.getValue());
        });


    }
}
