import java.util.Scanner;

public class T04_IsItPalindrome {

    static boolean isPalindrome(String str) {

        int i = 0;
        int j = str.length() - 1;

        while (i < j) {

            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Test if it is a palindrome?");
        String str = scanner.nextLine();

        boolean isItPalindrome = isPalindrome(str);

        if (isItPalindrome) {
            System.out.println("It is palindrome!");
        } else {
            System.out.println("No! It is not a palindrome.");
        }
    }
}
