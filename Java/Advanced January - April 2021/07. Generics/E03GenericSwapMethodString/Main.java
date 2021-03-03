package E03GenericSwapMethodString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box<String> box = new Box();

        for (int i = 0; i < n; i++) {
            String value = scanner.nextLine();
            box.addValue(value);
        }

        int[] indexes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int index1 = indexes[0];
        int index2 = indexes[1];

        box.swap(index1, index2);

        System.out.println(box);
    }
}
