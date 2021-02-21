import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E07FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "\\w+\\.?\\w+@\\w+\\.[us|uk|com]+";
        Pattern pattern = Pattern.compile(regex);

        Map<String, String> logbook = new LinkedHashMap<>();

        String name = scanner.nextLine();

        while (!name.equals("stop")) {
            String email = scanner.nextLine();

            Matcher matcher = pattern.matcher(email);

            if (matcher.find()) {
                name = scanner.nextLine();
                continue;
            } else {
                logbook.put(name, email);
            }

            name = scanner.nextLine();
        }

        logbook.forEach((key, value) -> {
            System.out.println(String.format("%s -> %s", key, value));
        });
    }
}
