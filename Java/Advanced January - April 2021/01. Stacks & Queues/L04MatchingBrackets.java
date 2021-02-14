import java.util.ArrayDeque;
import java.util.Scanner;

public class L04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char element = expression.charAt(i);

            if (element == '(') {
                stack.push(i);
            } else if (element == ')') {
                int startIndex = stack.pop();
                String discovery = expression.substring(startIndex, i + 1);
                System.out.println(discovery);
            }
        }
    }
}
