import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("");

        int n1 = Integer.parseInt(input[0]);
        int n2 = Integer.parseInt(input[1]);
        int n3 = Integer.parseInt(input[2]);

        int result1 = n1 + n2 + n3;
        int result2 = n1 * n2 * n3;
        int result3 = n1 * n2 + n3;
        int result4 = n1 + n2 * n3;

        int result_1 = Math.max(result1, result2);
        int result_2 = Math.max(result3, result4);

        System.out.println(Math.max(result_1, result_2));
    }
}
