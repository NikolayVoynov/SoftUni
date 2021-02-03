import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FE02EmojiDetector2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regexDigit = "\\d";
        Pattern patternDigit = Pattern.compile(regexDigit);

        Matcher matcherDigit = patternDigit.matcher(input);

        long coolThreshold = 1;

        while (matcherDigit.find()) {
            coolThreshold *= Integer.parseInt(matcherDigit.group());
        }

        System.out.println("Cool threshold: " + coolThreshold);

        String regexEmojis = "([:]{2}|[*]{2})([A-Z][a-z]{2,})\\1";
        Pattern patternEmojis = Pattern.compile(regexEmojis);

        Matcher matcherEmojis = patternEmojis.matcher(input);

        List<String> listCoolOnes = new ArrayList<>();
        int counterEmojis = 0;

        while (matcherEmojis.find()) {
            counterEmojis++;
            String emoji = matcherEmojis.group();
            String textEmoji = matcherEmojis.group(2);
            long coolThresholdEmoji = 0;

            for (int i = 0; i < textEmoji.length(); i++) {
                int ascii = textEmoji.charAt(i);
                coolThresholdEmoji += ascii;
            }

            if (coolThresholdEmoji >= coolThreshold) {
                listCoolOnes.add(emoji);
            }
        }

        System.out.printf("%d emojis found in the text. The cool ones are:%n", counterEmojis);

        if (!listCoolOnes.isEmpty()) {
            listCoolOnes.forEach(e-> System.out.println(e));
        }

    }
}
