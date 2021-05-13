import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ME01SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            numbers.add(Integer.parseInt(scanner.nextLine()));
        }

        Collections.sort(numbers, (n1,n2)->n2.compareTo(n1));
        numbers.stream().forEach(n-> System.out.println(n));
    }
}
