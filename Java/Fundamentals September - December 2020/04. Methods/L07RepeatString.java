import java.util.Scanner;

public class L07RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        System.out.print(printString(text, n));
    }

    private static String printString(String text, int n) {
        String result = "";

        for (int i = 0; i < n; i++) {
            result += text;
        }

        return result;
    }
}
