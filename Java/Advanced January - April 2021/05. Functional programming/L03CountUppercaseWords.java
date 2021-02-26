import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class L03CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] textWords = scanner.nextLine().split("\\s+");

        Predicate<String> checkForCapital = word -> Character.isUpperCase(word.charAt(0));

        List<String> wordsWithCapital = new ArrayList<>();

        for (String word : textWords) {
            if (checkForCapital.test(word)) {
               wordsWithCapital.add(word);
            }
        }

        System.out.println(wordsWithCapital.size());
        for (String s : wordsWithCapital) {
            System.out.println(s);
        }


    }
}
