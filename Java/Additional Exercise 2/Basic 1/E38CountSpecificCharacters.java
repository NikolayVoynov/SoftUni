package Basic1;

import java.util.Scanner;

public class E38CountSpecificCharacters {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input string: ");
        String input = scanner.nextLine();
        char[] characters = input.toCharArray();
        int numbers = 0;
        int letters = 0;
        int spaces = 0;
        int other = 0;

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(characters[i])) {
                numbers++;
            } else if (Character.isLetter(characters[i])) {
                letters++;
            } else if (Character.isSpaceChar(characters[i])) {
                spaces++;
            } else {
                other++;
            }
        }

        System.out.println("letter: " + letters);
        System.out.println("number: " + numbers);
        System.out.println("space: " + spaces);
        System.out.println("other: " + other);
    }
}
