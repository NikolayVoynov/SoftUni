import java.util.Scanner;

public class E02SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();
        int sum = 0;

        for (int i = 0; i < number.length(); i++) {
            char digit = number.charAt(i);
            sum += (digit - 48);
        }
        System.out.println(sum);
    }
}
