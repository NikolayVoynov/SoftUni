import java.util.Scanner;

public class E01ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] usernames = scanner.nextLine().split(", ");

        for (String username : usernames) {
            if (validUsername(username)) {
                System.out.println(username);
            }
        }
    }

    private static boolean validUsername(String username) {
        if (username.length() < 3 || username.length() > 16) {
            return false;
        }

        for (int i = 0; i < username.length(); i++) {
            char symbol = username.charAt(i);

            if (!Character.isAlphabetic(symbol) && !Character.isDigit(symbol)
                    && symbol != '_' && symbol != '-') {
                return false;
            }
        }
        return true;
    }
}
