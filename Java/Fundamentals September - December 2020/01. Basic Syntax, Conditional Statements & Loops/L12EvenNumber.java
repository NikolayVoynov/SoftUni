import java.util.Scanner;

public class L12EvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        while (input != 0) {

            if (Math.abs(input) % 2 != 0) {
                System.out.println("Please write an even number.");
            } else {
                System.out.println("The number is: " + Math.abs(input));
                return;
            }

            input = Integer.parseInt(scanner.nextLine());
        }
    }
}
