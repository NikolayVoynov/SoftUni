import java.util.*;

public class ME01SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            numbers.add(Integer.parseInt(scanner.nextLine()));
        }

        numbers.sort(Comparator.reverseOrder());
        numbers.forEach(n-> System.out.println(n));
    }
}
