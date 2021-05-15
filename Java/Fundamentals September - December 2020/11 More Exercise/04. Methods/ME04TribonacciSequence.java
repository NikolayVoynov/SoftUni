import java.util.Scanner;

public class ME04TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[num];
        numbers[0] = 1;


        for (int i = 1; i < num; i++) {
            int second = 0;
            int third = 0;

            int first = numbers[i - 1];
            if (i - 2 >= 0) {
                second = numbers[i - 2];
            }
            if (i - 3 >= 0) {
                third = numbers[i - 3];
            }

            numbers[i] = first + second + third;
        }

        StringBuilder result = new StringBuilder();

        for (int number : numbers) {
            result.append(number).append(" ");
        }

        System.out.println(result.toString().trim());
    }
}
