import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class T11_BalancedBrackets {

    static boolean areBracketsBalanced(String str) {

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {

            char a = str.charAt(i);

            if (a == '(' || a == '{' || a == '[') {
                stack.push(a);
            }

            if (stack.isEmpty()) {
                return false;
            }

            char x;

            switch (a) {
                case ')':
                    x = stack.pop();
                    if (x == '{' || x == '[') {
                        return false;
                    }
                    break;
                case '}':
                    x = stack.pop();
                    if (x == '(' || x == '[') {
                        return false;
                    }
                    break;
                case ']':
                    x = stack.pop();
                    if (x == '{' || x == '(') {
                        return false;
                    }
                    break;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter brackets string for check:");
        String check = scanner.nextLine();

        if (areBracketsBalanced(check)) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not balanced!");
        }
    }
}
