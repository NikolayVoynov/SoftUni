import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ME05Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            int[] number = Arrays.stream(scanner.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
            int mainDigit = number[0];
            if (mainDigit == 0) {
                System.out.print(" ");
            } else {
                int numberLength = number.length;
                int offset = (mainDigit - 2) * 3;
                if (mainDigit == 8 || mainDigit == 9) {
                    offset += 1;
                }
                int letterIndex = offset + numberLength - 1;
                int printLetterASCII = 97 + letterIndex;
                System.out.print((char) printLetterASCII);
            }
        }
    }
}
