import java.util.Arrays;
import java.util.Scanner;

public class E02_Stairs_Recursion {

    public static long[] memory;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int stairs = Integer.parseInt(scanner.nextLine());
        memory = new long[stairs + 1];
        Arrays.fill(memory, -1);

        System.out.println(climbStairs(stairs));
    }

    private static long climbStairs(int stairs) {
        if (memory[stairs] != -1) {
            return memory[stairs];
        }

        if (stairs == 1) {
            return 1;
        }

        if (stairs == 2) {
            return 2;
        }

        return memory[stairs] = climbStairs(stairs - 1) + climbStairs(stairs - 2);
    }
}
