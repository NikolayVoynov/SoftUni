import java.util.Arrays;
import java.util.Scanner;

public class M02FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < lines; i++) {
            long sumDigits = 0;
            String[] array = scanner.nextLine().split("\\s+");
            String first = array[0];
            String second = array[1];

            if (Long.parseLong(first) < Long.parseLong(second)) {
                String[] elements = second.split("");
                for (String element : elements) {
                    if (!element.equals("-"))
                    sumDigits += Integer.parseInt(element);
                }
                System.out.println(sumDigits);
            } else if (Long.parseLong(first) > Long.parseLong(second)) {
                String[] elements = first.split("");
                for (String element : elements) {
                    if (!element.equals("-"))
                        sumDigits += Integer.parseInt(element);
                }
                System.out.println(sumDigits);
            } else {
                String[] elements = second.split("");
                for (String element : elements) {
                    if (!element.equals("-"))
                        sumDigits += Integer.parseInt(element);
                }
                System.out.println(sumDigits);
            }
        }
    }
}
