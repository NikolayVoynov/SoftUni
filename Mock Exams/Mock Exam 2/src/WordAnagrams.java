import java.util.Arrays;
import java.util.Scanner;

public class WordAnagrams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String checkAgainst = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();

            if (isAnagram(line, checkAgainst)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static boolean isAnagram(String line, String checkAgainst) {
        if (line.length() != checkAgainst.length()) {
            return false;
        }

        char[] first = line.toCharArray();
        char[] second = checkAgainst.toCharArray();

        int asciiSumFirst = 0;
        for (int i = 0; i < first.length; i++) {
            int ascii = (int) first[i];
            asciiSumFirst += ascii;
        }

        int asciiSumSecond = 0;
        for (int i = 0; i < second.length; i++) {
            int ascii = (int) second[i];
            asciiSumSecond += ascii;
        }

        return asciiSumFirst == asciiSumSecond;
    }
}
