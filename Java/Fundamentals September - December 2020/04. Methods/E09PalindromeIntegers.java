import java.util.Scanner;

public class E09PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            System.out.println(isPalindrome(input));

            input = scanner.nextLine();
        }
    }

    private static boolean isPalindrome(String input) {
        String reversedInput = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            char currentLetter = input.charAt(i);
            reversedInput += currentLetter;
        }

        if (input.equals(reversedInput)) {
            return true;
        }
        return false;
    }
}
