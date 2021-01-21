import java.util.Scanner;

public class E05AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());

        int sumOfFirstAndSecond = sum(first, second);
        System.out.println(subtract(sumOfFirstAndSecond, third));

    }

    private static int sum(int first, int second) {
        return first + second;
    }

    private static int subtract(int sumOfFirstAndSecond, int third) {
        return sumOfFirstAndSecond - third;
    }
}
