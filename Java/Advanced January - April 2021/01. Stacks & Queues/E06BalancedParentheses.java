import java.util.ArrayDeque;
import java.util.Scanner;

public class E06BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] parenthesis = scanner.nextLine().split("");

        ArrayDeque<String> queue = new ArrayDeque<>();
        ArrayDeque<String> stack = new ArrayDeque<>();

        boolean notBalanced = false;

        if (parenthesis.length % 2 == 0) {

            for (int i = 0; i < parenthesis.length / 2; i++) {
                queue.offer(parenthesis[i]);
            }

            for (int i = parenthesis.length / 2; i < parenthesis.length; i++) {
                stack.push(parenthesis[i]);
            }

            for (int i = 0; i < queue.size(); i++) {

                switch (queue.poll()) {
                    case "(":
                        if (stack.pop().equals(")")) {
                            notBalanced = false;
                        } else {
                            notBalanced = true;
                            break;
                        }
                        break;
                    case "[":
                        if (stack.pop().equals("]")) {
                            notBalanced = false;
                        } else {
                            notBalanced = true;
                            break;
                        }
                        break;
                    case "{":
                        if (stack.pop().equals("}")) {
                            notBalanced = false;
                        } else {
                            notBalanced = true;
                            break;
                        }
                        break;
                }
            }
        } else {
            notBalanced = true;
        }

        if (notBalanced) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }


    }
}
