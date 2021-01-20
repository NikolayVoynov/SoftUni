import java.util.Arrays;
import java.util.Scanner;

public class E01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] train = new int[n];
        int totalPassengers = 0;

        for (int i = 0; i < n; i++) {
            train[i] = Integer.parseInt(scanner.nextLine());
            totalPassengers += train[i];

            System.out.print(train[i] + " ");
        }

        System.out.println();
        System.out.print(totalPassengers);


    }
}
