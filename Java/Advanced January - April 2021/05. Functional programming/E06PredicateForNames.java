import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class E06PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());

        String[] text = scanner.nextLine().split("\\s+");

        Predicate<String> predicate = word -> word.length() <= length;

        Arrays.stream(text).filter(predicate).forEach(element -> System.out.println(element));
    }
}
