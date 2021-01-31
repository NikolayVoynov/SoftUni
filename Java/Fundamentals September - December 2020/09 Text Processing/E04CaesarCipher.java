import java.util.Scanner;

public class E04CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        StringBuilder encryptText = new StringBuilder();

        int asciiCurrentSymbol = 0;

        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);
            asciiCurrentSymbol = (char) currentSymbol;

            char encryptSymbol = (char) (asciiCurrentSymbol + 3);

            encryptText.append(encryptSymbol);
        }

        System.out.println(encryptText);

    }
}
