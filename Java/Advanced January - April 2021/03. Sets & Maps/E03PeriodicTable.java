import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class E03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> finalSetElements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] elements = scanner.nextLine().split(" ");

            for (String element : elements) {
                finalSetElements.add(element);
            }
        }

        for (String finalSetElement : finalSetElements) {
            System.out.print(finalSetElement + " ");
        }


    }
}
