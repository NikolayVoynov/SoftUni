import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E06ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split("\\s+");

        String regexValidEmail = "[A-Za-z0-9]+[\\w\\.\\-]*[A-Za-z0-9]+@[A-Za-z]+[A-Za-z\\-\\.]*\\.[A-Za-z]+";
        Pattern patternValidEmail = Pattern.compile(regexValidEmail);

        List<String> validEmails = new ArrayList<>();

        for (String word:
             text) {
            Matcher matcherValidEmail = patternValidEmail.matcher(word);

            if (matcherValidEmail.find()) {
                String validEmail = matcherValidEmail.group();
                validEmails.add(validEmail);
            }
        }

        validEmails.forEach(e-> System.out.println(e.toString()));
    }
}
