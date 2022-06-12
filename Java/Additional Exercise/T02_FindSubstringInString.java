import java.util.Scanner;

public class T02_FindSubstringInString {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert string:");
        String string = scanner.nextLine();

        System.out.println("Insert substring:");
        String substring = scanner.nextLine();

        if (string.contains(substring)) {
            System.out.println(string.indexOf(substring));
        } else {
            System.out.println("String does not contain this substring.");
        }
    }
}
