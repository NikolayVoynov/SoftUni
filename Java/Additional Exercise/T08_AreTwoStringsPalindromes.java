import java.util.*;

public class T08_AreTwoStringsPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert first string:");
        List<String> str1 = new ArrayList<>(Arrays.asList(scanner.nextLine().split("")));
        System.out.println("Insert second string:");
        List<String> str2 = new ArrayList<>(Arrays.asList(scanner.nextLine().split("")));

        Collections.reverse(str1);

        for (int i = 0; i < str1.size(); i++) {
            if (!str1.get(i).equals(str2.get(i))) {
                System.out.println("Two strings are NOT palindromes!");
                return;
            }
        }

        System.out.println("Two strings ARE palindromes!");

    }
}
