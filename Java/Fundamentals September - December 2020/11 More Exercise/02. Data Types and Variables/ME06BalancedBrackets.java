import java.util.Scanner;

public class ME06BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lastBracket = "";
        boolean isBalanced = true;
        int numberOfBrackets = 0;

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            if (input.equals("(") || input.equals(")")) {
                numberOfBrackets++;
                if (!input.equals(lastBracket)) {
                    lastBracket = input;
                } else {
                    isBalanced = false;
                    break;
                }
            }
        }

        if (isBalanced && numberOfBrackets % 2 == 0) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
