import java.util.*;
import java.util.stream.Collectors;

public class ME04ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> string = Arrays.stream(scanner.nextLine().split("")).collect(Collectors.toList());
        for (int i = 0; i < string.size() / 2; i++) {
            String newElement = string.get(string.size() - 1 - i);
            String currentElement = string.get(i);
            string.set(i, newElement);
            string.set(string.size() - 1 - i, currentElement);
        }
        System.out.println(String.join("", string));
    }
}
