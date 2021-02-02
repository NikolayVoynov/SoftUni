import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FE02Problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            String regex = "^([$]|[%])([A-Z][a-z]{2,})\\1(: )\\[(?<fd>\\d+)\\]\\|\\[(?<sd>\\d+)\\]\\|\\[(?<td>\\d+)\\]\\|$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                int fd = Integer.parseInt(matcher.group("fd"));
                int sd = Integer.parseInt(matcher.group("sd"));
                int td = Integer.parseInt(matcher.group("td"));

                char fdLetter = (char) fd;
                char sdLetter = (char) sd;
                char tdLetter = (char) td;

                System.out.printf("%s: %c%c%c%n", matcher.group(2), fdLetter, sdLetter, tdLetter);

            } else {
                System.out.println("Valid message not found!");
            }


        }


    }
}
