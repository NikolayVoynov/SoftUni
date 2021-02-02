import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FE01Problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String email = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("Complete")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Make":
                    String secondCommand = tokens[1];
                    if (secondCommand.equals("Upper")) {
                        email = email.toUpperCase();

                    } else if (secondCommand.equals("Lower")) {
                        email = email.toLowerCase();

                    }
                    System.out.println(email);
                    break;

                case "GetDomain":
                    int count = Integer.parseInt(tokens[1]);
                    int beginIndex = email.length() - count;
                    String domain = email.substring(beginIndex);
                    System.out.println(domain);
                    break;

                case "GetUsername":
                    if (email.contains("@")) {
                        int indexOfMonkeyA = email.indexOf("@");
                        String username = email.substring(0, indexOfMonkeyA);
                        System.out.println(username);
                    } else {
                        System.out.printf("The email %s doesn't contain the @ symbol.%n", email);
                    }
                    break;

                case "Replace":
                    String character = tokens[1];
                    String replacement = "-";
                    email = email.replaceAll(Pattern.quote(character), replacement);
                    System.out.println(email);
                    break;
                case "Encrypt":
                    List<Integer> asciiList = new ArrayList<>();
                    for (int i = 0; i < email.length(); i++) {
                        int ascii = email.charAt(i);
                        asciiList.add(ascii);
                    }
                    System.out.println(asciiList.toString().replaceAll("[\\[\\]\\,]", ""));
                    break;
            }


            input = scanner.nextLine();
        }
    }
}
