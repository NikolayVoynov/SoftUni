import java.util.Scanner;

public class ME05DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String letter = scanner.nextLine();
            int letterASCII = letter.charAt(0);
            int newLetterASCII = letterASCII + key;

            System.out.print((char) newLetterASCII);
        }
    }
}
