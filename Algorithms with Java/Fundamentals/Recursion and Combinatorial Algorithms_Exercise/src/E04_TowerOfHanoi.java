import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.stream.Collectors;

public class E04_TowerOfHanoi {
    public static StringBuilder builder = new StringBuilder();

    public static Deque<Integer> source = new ArrayDeque<>();
    public static Deque<Integer> spare = new ArrayDeque<>();
    public static Deque<Integer> destination = new ArrayDeque<>();

    public static int steps = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int disk = Integer.parseInt(reader.readLine());

        for (int i = disk; i >= 1; i--) {
            source.push(i);
        }

        printRods();
        solve(disk, source, destination, spare);

        System.out.println(builder.toString());
    }

    public static void solve(int disk, Deque<Integer> source, Deque<Integer> destination, Deque<Integer> spare) {
        if (disk == 1) {
            destination.push(source.pop());
            builder.append("Step #")
                    .append(steps++)
                    .append(": Moved disk")
                    .append(System.lineSeparator());
            printRods();
        } else {
            solve(disk - 1, source, spare, destination);
            solve(1, source, destination, spare);
            solve(disk - 1, spare, destination, source);
        }
    }

    public static void printRods() {
        builder.append(String.format("Source: %s%nDestination: %s%nSpare: %s%n",
                formatRod(source), formatRod(destination), formatRod(spare)))
                .append(System.lineSeparator());
    }

    public static String formatRod(Deque<Integer> stack) {
        return stack
                .stream()
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
