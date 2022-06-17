import java.util.Scanner;

public class T12_MergeString {

    static String mergeString(String str1, String str2) {

        return str1.concat(str2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first string:");
        String str1 = scanner.nextLine();

        System.out.println("Enter second string:");
        String str2 = scanner.nextLine();

        System.out.println(mergeString(str1, str2));

    }
}
