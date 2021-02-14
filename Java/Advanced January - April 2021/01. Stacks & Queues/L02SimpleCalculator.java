import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class L02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] elements = scanner.nextLine().split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, elements);

        while (stack.size() > 1) {
            int first = Integer.parseInt(stack.pop());
            String operand = stack.pop();
            int second = Integer.parseInt(stack.pop());

            switch (operand) {
                case "+":
                    stack.push(String.valueOf(first+second));
                    break;
                case "-":
                    stack.push(String.valueOf(first-second));
                    break;
            }
        }

        System.out.println(stack.pop());

    }
}
