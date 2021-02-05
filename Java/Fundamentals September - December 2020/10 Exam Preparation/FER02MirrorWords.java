import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FER02MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regexWordPairs = "([@]|[#])(?<first>[A-Za-z]{3,})\\1\\1(?<second>[A-Za-z]{3,})\\1";
        Pattern patternWordPairs = Pattern.compile(regexWordPairs);
        Matcher matcherWordPairs = patternWordPairs.matcher(input);

        List<String> listMirrorWords = new ArrayList<>();

        int counterWordPairs = 0;

        while (matcherWordPairs.find()) {
            counterWordPairs++;
            String firstWord = matcherWordPairs.group("first");
            String second = matcherWordPairs.group("second");

            String secondWord = "";

            for (int i = second.length() - 1; i >= 0; i--) {
                char currentLetter = second.charAt(i);
                secondWord += currentLetter;
            }

            if (firstWord.equals(secondWord)) {
                String mirrorWords = firstWord + " <=> " + second;
                listMirrorWords.add(mirrorWords);
            }
        }

        if (counterWordPairs==0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", counterWordPairs);
        }

        if (listMirrorWords.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", listMirrorWords));
        }
    }
}
