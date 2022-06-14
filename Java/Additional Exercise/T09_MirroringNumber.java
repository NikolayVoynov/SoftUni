import java.util.Scanner;

public class T09_MirroringNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number:");
        int number = Integer.parseInt(scanner.nextLine());

        System.out.println("Original number is: " + number);

        int revNum = 0;

        while (number != 0) {
            int digit = number % 10;
            revNum = revNum * 10 + digit;
            number /= 10;
        }

        System.out.println("Reversed number is: " + revNum);
    }
}
