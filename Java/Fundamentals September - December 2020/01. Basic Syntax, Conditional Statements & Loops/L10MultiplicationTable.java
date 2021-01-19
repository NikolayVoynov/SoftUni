import java.util.Scanner;

public class L10MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int digit = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= 10; i++) {

            int result = digit * i;
            System.out.println(digit + " X " + i + " = " + result);
        }
    }
}
