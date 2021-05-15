import java.util.Scanner;

public class ME01DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        while (!"END".equals(input = scanner.nextLine())) {
            if (input.matches("-?\\d+")) {
                System.out.printf("%s is integer type%n", input);
            } else if (input.matches("-?\\d+\\.\\d+")) {
                System.out.printf("%s is floating point type%n", input);
            } else if (input.length() == 1) {
                System.out.printf("%s is character type%n", input);
            } else {
                if (input.equals("true") || input.equals("false")) {
                    System.out.printf("%s is boolean type%n", input);
                } else {
                    System.out.printf("%s is string type%n", input);
                }
            }
        }
    }
}
