import java.util.Scanner;

public class E03CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char first = scanner.nextLine().charAt(0);
        char last = scanner.nextLine().charAt(0);

        charactersInBetween(first, last);
    }

    private static void charactersInBetween(char first, char last) {
        if (first < last) {
            for (char i = (char) (first + 1); i < last; i++) {
                System.out.print(i + " ");
            }
        } else {
            for (char i = (char) (last + 1); i < first; i++) {
                System.out.print(i + " ");
            }
        }


    }
}
