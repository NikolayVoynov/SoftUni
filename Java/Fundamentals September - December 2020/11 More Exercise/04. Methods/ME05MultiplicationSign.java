import java.util.Scanner;

public class ME05MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int quantityOfNegativeNumbers = 0;
        boolean zeroMultiplier = false;

        for (int i = 0; i < 3; i++) {
            double number = Double.parseDouble(scanner.nextLine());

            if (number == 0) {
                zeroMultiplier = true;
                break;
            } else if (number < 0) {
                quantityOfNegativeNumbers++;
            }
        }
        if (zeroMultiplier) {
            System.out.println("zero");
        } else if (quantityOfNegativeNumbers % 2 == 0) {
            System.out.println("positive");
        } else {
            System.out.println("negative");
        }
    }
}
