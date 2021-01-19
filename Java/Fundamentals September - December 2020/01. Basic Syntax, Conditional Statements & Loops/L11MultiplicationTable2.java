import java.util.Scanner;

public class L11MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int theInteger = Integer.parseInt(scanner.nextLine());
        int multiplier = Integer.parseInt(scanner.nextLine());

        int product = 0;

        if (multiplier > 10) {
            product = theInteger * multiplier;
            System.out.println(theInteger + " X " + multiplier + " = " + product);
        }

        for (int i = multiplier; i <= 10; i++) {
            product = theInteger *i;
            System.out.println(theInteger + " X " + i + " = " + product);
        }

    }
}
