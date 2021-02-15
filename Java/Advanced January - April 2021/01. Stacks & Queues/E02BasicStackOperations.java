import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class E02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] commands = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int nPush = commands[0];
        int sPop = commands[1];
        int xCheck = commands[2];

        int min = Integer.MAX_VALUE;

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < nPush; i++) {
            int number = numbers[i];
            stack.push(number);
        }

        for (int i = 0; i < sPop; i++) {
            stack.pop();
        }

        if (!stack.isEmpty()) {
            if (stack.contains(xCheck)) {
                System.out.println("true");
            } else {
                while (!stack.isEmpty()) {
                    int current = stack.pop();
                    if (current < min) {
                        min = current;
                    }
                }

                System.out.println(min);
            }
        } else {
            System.out.println(0);
        }


    }
}
