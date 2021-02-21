import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class E02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] info = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int n = info[0];
        int m = info[1];

        Set<String> firstSet = new LinkedHashSet<>();
        Set<String> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String element = scanner.nextLine();
            firstSet.add(element);
        }

        for (int i = 0; i < m; i++) {
            String element = scanner.nextLine();
            secondSet.add(element);
        }

        firstSet.forEach(e->{
            if (secondSet.contains(e)) {
                System.out.print(e + " ");
            }
        });
    }
}
