import java.util.Scanner;

public class E02_Stairs_Memoization {

    public static long[] memory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int stairs = Integer.parseInt(scanner.nextLine());

        memory = new long[stairs + 1];

        memory[1] = 1;
        memory[2] = 2;

        for (int i = 3; i <= stairs; i++) {
            memory[i] = memory[i - 1] + memory[i-2];
        }

        System.out.println(memory[stairs]);
    }
}
