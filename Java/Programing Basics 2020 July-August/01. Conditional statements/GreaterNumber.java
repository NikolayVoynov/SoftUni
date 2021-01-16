import java.util.Scanner;

public class GreaterNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberFirst = Integer.parseInt(scanner.nextLine());
        int numberSecond = Integer.parseInt(scanner.nextLine());

        if (numberFirst > numberSecond) {

            System.out.println(numberFirst);

        } else {

            System.out.println(numberSecond);
        }

    }
}
