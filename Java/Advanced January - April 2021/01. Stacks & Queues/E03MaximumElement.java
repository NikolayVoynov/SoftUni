import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class E03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];

            switch (command) {
                case "1":
                    int elementX = Integer.parseInt(input[1]);
                    stack.push(elementX);
                    break;
                case "2":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }

                    break;
                case "3":
                    System.out.println(Collections.max(stack));
                    break;
            }
        }
    }
}
