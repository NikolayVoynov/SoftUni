import java.util.Scanner;

public class E04PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        if (!ifIsBetween(password)) {
            System.out.println("Password must be between 6 and 10 characters");
        }

        if (!onlyDigitsAndLetters(password)) {
            System.out.println("Password must consist only of letters and digits");
        }

        if (!haveAtLeast2Digits(password)) {
            System.out.println("Password must have at least 2 digits");
        }

        if ( ifIsBetween(password) && onlyDigitsAndLetters(password) && haveAtLeast2Digits(password)) {
            System.out.println("Password is valid");
        }
    }

    private static boolean ifIsBetween(String password) {
        return 6 <= password.length() && password.length() <= 10;
    }

    private static boolean onlyDigitsAndLetters(String password) {
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);
            boolean isLetter = Character.isLetter(symbol);
            boolean isDigit = Character.isDigit(symbol);

            if (!isLetter && !isDigit) {
                return false;
            }
        }
        return true;
    }

    private static boolean haveAtLeast2Digits(String password) {
        int counter = 0;
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);
            if (Character.isDigit(symbol)) {
                counter++;
            }
        }
        if (counter >= 2) {
            return true;
        }
        return false;
    }
}
