import java.util.Scanner;

public class E06ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder();

        char previousChar = input.charAt(0);
        sb.append(previousChar);

        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar != previousChar) {
                sb.append(currentChar);
                previousChar = currentChar;
            }
        }
        System.out.println(sb);
    }
}
