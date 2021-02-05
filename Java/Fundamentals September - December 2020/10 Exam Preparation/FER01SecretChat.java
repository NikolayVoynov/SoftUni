import java.util.Scanner;
import java.util.regex.Pattern;

public class FER01SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String concealedMessage = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("Reveal")) {
            String[] tokens = input.split(":\\|:");
            String command = tokens[0];

            switch (command) {
                case "InsertSpace":
                    int index = Integer.parseInt(tokens[1]);
                    concealedMessage = concealedMessage.substring(0, index) + " " + concealedMessage.substring(index);
                    System.out.println(concealedMessage);
                    break;


                case "Reverse":
                    String searchFor = tokens[1];
                    if (concealedMessage.contains(searchFor)) {
                        String replacement = new StringBuilder(searchFor).reverse().toString();

                        concealedMessage = concealedMessage.replaceFirst(Pattern.quote(searchFor), "") + replacement;
                        System.out.println(concealedMessage);
                    } else {
                        System.out.println("error");
                    }

                    break;

                case "ChangeAll":
                    String searchForAll = tokens[1];
                    String replacement = tokens[2];

                    concealedMessage = concealedMessage.replaceAll(searchForAll, replacement);
                    System.out.println(concealedMessage);
                    break;

            }
            input = scanner.nextLine();
        }

        System.out.println("You have a new text message: " + concealedMessage);
    }

}


