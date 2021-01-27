import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E03MatchDates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "\\b(?<day>\\d{2})([-.\\/])(?<month>[A-Z][a-z]{2})\\2(?<year>\\d{4})\\b";
        String dates = scanner.nextLine();

        Pattern patternDate = Pattern.compile(regex);
        Matcher matchDate = patternDate.matcher(dates);

        while (matchDate.find()) {
            System.out.printf("Day: %s, Month: %s, Year: %s%n", matchDate.group("day"), matchDate.group("month"), matchDate.group("year"));
        }
    }
}
