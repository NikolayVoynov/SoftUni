import java.util.*;
import java.util.stream.Collectors;

public class ME03Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int sum = 0;

        for (int i = 0; i < listNumbers.size(); i++) {
            sum += listNumbers.get(i);
        }

        double averageValue = 1.0 * sum / listNumbers.size();

        List<Integer> topNumbers = new ArrayList<>();

        for (int i = 0; i < listNumbers.size(); i++) {
            int currentNumber = listNumbers.get(i);

            if (currentNumber > averageValue) {
                topNumbers.add(currentNumber);
            }
        }

        if (topNumbers.size() == 0) {
            System.out.println("No");

        } else {
            List<Integer> sorted = topNumbers.stream()
                    .sorted(Comparator.reverseOrder()).collect(Collectors.toList());

            List<Integer> top5Numbers = new ArrayList<>();

            if (sorted.size() > 5) {
                for (int i = 0; i < 5; i++) {
                    top5Numbers.add(sorted.get(i));
                }
                System.out.print(top5Numbers.toString().replaceAll("[\\[\\]\\,]", ""));
            } else {
                System.out.print(sorted.toString().replaceAll("[\\[\\]\\,]", ""));
            }
        }
    }
}
