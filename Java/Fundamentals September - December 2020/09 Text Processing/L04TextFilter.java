import java.util.Scanner;

public class L04TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String bannedWord : bannedWords) {
            int numberAsterisks = bannedWord.length();
            StringBuilder replacement = new StringBuilder();

            for (int i = 0; i < numberAsterisks; i++) {
                replacement.append("*");
            }

            text = text.replace(bannedWord, replacement);
        }

        System.out.println(text);

    }
}
