import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.stream.Collectors;

public class E04_TowerOfHanoi {
    public static Deque<Integer> source = new ArrayDeque<>();
    public static Deque<Integer> spare = new ArrayDeque<>();
    public static Deque<Integer> destination = new ArrayDeque<>();

    public static int steps = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int disk = Integer.parseInt(reader.readLine());

        for (int i = disk; i >= 1; i--) {
            source.push(i);
        }

        solve(disk, source, spare, destination);
        printRods();
    }

    public static void solve(int disk, Deque<Integer> source, Deque<Integer> spare, Deque<Integer> destination) {
        if (disk == 1) {
            destination.push(source.pop());
            System.out.println("Step #" + (steps++) + ": Moved disk");
            printRods();
        }
    }

    public static void printRods() {
        System.out.println(String.format("Source: %s%n" +
                "Destination: %s%n" +
                "Spare: %s%n", formatRod(source), formatRod(spare), formatRod(destination)));
    }

    public static String formatRod(Deque<Integer> stack) {
        return stack
                .stream()
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
