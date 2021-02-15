import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class E04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] commands = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int nOffer = commands[0];
        int sRemove = commands[1];
        int xCheck = commands[2];

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < nOffer; i++) {
            queue.offer(numbers[i]);
        }

        for (int i = 0; i < sRemove; i++) {
            queue.pop();
        }

        if (queue.isEmpty()) {
            System.out.println(0);
        } else {
            if (queue.contains(xCheck)) {
                System.out.println("true");
            } else {
                System.out.println(Collections.min(queue));
            }
        }
    }
}
