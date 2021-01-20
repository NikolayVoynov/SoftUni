import java.util.Arrays;
import java.util.Scanner;

public class E04ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputLine = scanner.nextLine().split(" ");

        int rotations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < rotations; i++) {
            String firstElement = inputLine[0];

            for (int j = 0; j < inputLine.length - 1; j++) {
                inputLine[j] = inputLine[j + 1];
            }

            inputLine[inputLine.length - 1] = firstElement;
        }

        for (int i = 0; i < inputLine.length; i++) {
            System.out.print(inputLine[i] + " ");
        }
    }
}
