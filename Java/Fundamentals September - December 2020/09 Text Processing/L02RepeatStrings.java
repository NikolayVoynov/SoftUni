import java.util.Scanner;

public class L02RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");

        StringBuilder result = new StringBuilder();

        for (String word : words) {
            int count = word.length();

            for (int i = 0; i < count; i++) {
                result.append(word);
            }
        }

        System.out.println(result);
    }
}
