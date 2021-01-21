import java.util.Scanner;

public class E06MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        if (input.length() % 2 != 0) {
            getMiddleCharacterOddString(input);
        } else {
            getMiddleCharacterEvenString(input);
        }
    }

    private static void getMiddleCharacterOddString(String input) {
        char middleCharacter = input.charAt((input.length() / 2));
        System.out.println(middleCharacter);
    }

    private static void getMiddleCharacterEvenString(String input) {
        char firstMiddleCharacter = input.charAt((input.length() / 2) - 1);
        char secondMiddleCharacter = input.charAt(input.length() / 2);
        System.out.print(firstMiddleCharacter);
        System.out.print(secondMiddleCharacter);

    }
}
