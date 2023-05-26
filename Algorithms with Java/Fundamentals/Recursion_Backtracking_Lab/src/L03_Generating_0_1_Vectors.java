import java.util.Scanner;

public class L03_Generating_0_1_Vectors {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] memory = new int[n];
        int index = 0;

        fillVector(memory, index);
    }

    private static void fillVector(int[] memory, int index) {
        if (index >= memory.length) {
            printVector(memory);
            return;
        }

        for (int i = 0; i <= 1; i++) {
            memory[index] = i;
            fillVector(memory, index + 1);
        }
    }

    private static void printVector(int[] memory) {
        for (int element : memory) {
            System.out.print(element);
        }
        System.out.println();
    }
}
