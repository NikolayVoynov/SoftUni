import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class L04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] realNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> occurrenceRealNumbers = new LinkedHashMap<>();

        for (double realNumber : realNumbers) {
            if (!occurrenceRealNumbers.containsKey(realNumber)) {
                occurrenceRealNumbers.put(realNumber, 1);
            } else {
                occurrenceRealNumbers.put(realNumber, occurrenceRealNumbers.get(realNumber) + 1);
            }
        }

        occurrenceRealNumbers
                .forEach((key, value) -> System.out.println(String.format("%.1f -> %d", key, value)));

    }
}
