import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        int magicNumber = Integer.parseInt(scanner.nextLine());

        int result = 0;
        int counter = 0;
        String output = "";

        boolean magicNumberFound = false;

        for (int x = start; x <= end; x++) {
            for (int y = start; y <= end; y++) {
                counter++;

                if (x + y == magicNumber) {
                    output = String.format("Combination N:%d (%d + %d = %d)", counter, x, y, magicNumber);
                    magicNumberFound = true;
                    break;
                }
            }
            if (magicNumberFound) {
                break;
            }
        }

        if (magicNumberFound) {
            System.out.println(output);
        } else {
            System.out.printf("%d combinations - neither equals %d", counter, magicNumber);
        }
    }
}