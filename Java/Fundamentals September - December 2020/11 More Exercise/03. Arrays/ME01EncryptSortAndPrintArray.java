import java.util.Arrays;
import java.util.Scanner;

public class ME01EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] codesArray = new int[n];

        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            int key = word.length();

            int sumNewASCIICodes = 0;

            for (int j = 0; j < word.length(); j++) {
                String[] currentWord = word.split("");
                if (word.charAt(j) == 'a' || word.charAt(j) == 'o' || word.charAt(j) == 'e'
                        || word.charAt(j) == 'i' || word.charAt(j) == 'u' || word.charAt(j) == 'A'
                        || word.charAt(j) == 'O' || word.charAt(j) == 'E' || word.charAt(j) == 'I'
                        || word.charAt(j) == 'U') {

                    sumNewASCIICodes += (word.charAt(j) * key);
                } else {
                    sumNewASCIICodes += (word.charAt(j) / key);
                }
            }

            codesArray[i] = sumNewASCIICodes;
        }

        Arrays.sort(codesArray);
        for (int element : codesArray) {
            System.out.println(element);
        }
    }
}
