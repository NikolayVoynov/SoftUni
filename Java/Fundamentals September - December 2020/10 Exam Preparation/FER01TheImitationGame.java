import java.util.Scanner;
import java.util.regex.Pattern;

public class FER01TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        String instructions = scanner.nextLine();

        while (!instructions.equals("Decode")) {
            String[] tokens = instructions.split("\\|");
            String command = tokens[0];

            switch (command) {
                case "Move":
                    int numberOfLetters = Integer.parseInt(tokens[1]);
                    if (numberOfLetters <= message.length()) {
                        String moveString = message.substring(0, numberOfLetters);
                        message = message.replaceFirst(Pattern.quote(moveString), "");
                        message += moveString;
                    }

                    break;

                case "Insert":
                    int index = Integer.parseInt(tokens[1]);
                    String value = tokens[2];
                    if (index <= message.length()) {
                        message = message.substring(0,index) + value + message.substring(index);
                    }

                    break;

                case "ChangeAll":
                    String substring = tokens[1];
                    String replacement = tokens[2];
                    if (message.contains(substring)) {
                        message = message.replaceAll(Pattern.quote(substring), replacement);
                    }

                    break;
            }

            instructions = scanner.nextLine();
        }

        System.out.printf("The decrypted message is: %s", message);

    }
}
