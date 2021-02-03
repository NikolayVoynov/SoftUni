import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FER02AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "(\\#|\\|)(?<item>[A-Za-z ]+)\\1(?<expirationDate>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>\\d+)\\1";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);

        int sumCalories = 0;

        List<String> infoItems = new ArrayList<>();

        while (matcher.find()) {
            String item = matcher.group("item");
            String expirationDate = matcher.group("expirationDate");
            String calories = matcher.group("calories");

            String info = String.format("Item: %s, Best before: %s, Nutrition: %s", item, expirationDate, calories);
            infoItems.add(info);

            sumCalories += Integer.parseInt(matcher.group("calories"));
        }

        int daysCanLast = sumCalories / 2000;
        System.out.printf("You have food to last you for: %d days!%n", daysCanLast);

        infoItems.forEach(e-> System.out.println(e));
    }
}
