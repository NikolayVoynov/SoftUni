import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Scanner;

public class L07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] kids = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        int cycle = 1;

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String kid : kids) {
            queue.offer(kid);
        }

        while (queue.size() > 1) {

            for (int i = 1; i < n; i++) {
                queue.offer(Objects.requireNonNull(queue.poll()));
            }

                if (isComposite(cycle)) {
                    System.out.println("Removed " + queue.poll());

                } else {
                    System.out.println("Prime " + queue.peek());

                }

            cycle++;
        }

        System.out.println("Last is " + queue.poll());
    }

    public static boolean isComposite(int cycle) {
        for (int i = 2; i < cycle; i++) {
            if (cycle % i == 0) {
                return true;
            }
        }
        return false;
    }
}
